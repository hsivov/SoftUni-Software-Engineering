package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ComputerManagerTests {

    private static final String TEST_MANUFACTURER = "Asus";
    private static final String TEST_MODEL = "ROG";
    private static final double TEST_PRICE = 1059.99;

    Computer computer;

    ComputerManager computerManager;
    private List<Computer> computers;

    @Before
    public void setUp() {
        computer = new Computer(TEST_MANUFACTURER, TEST_MODEL, TEST_PRICE);
        computerManager = new ComputerManager();
        computers = List.of(new Computer("Asus", "ROG", 2250.25),
                new Computer("Acer", "Predator", 3350.20),
                new Computer("MSI", "Titan", 4999.95));
    }

    @Test
    public void testConstructorShouldCreate() {
        assertEquals(TEST_MANUFACTURER, computer.getManufacturer());
        assertEquals(TEST_MODEL, computer.getModel());
        assertEquals(TEST_PRICE, computer.getPrice(), 0.1);
    }

    @Test
    public void testAddComputersShouldAdd() {
        int sizeBefore = computerManager.getCount();
        computerManager.addComputer(computer);

        assertEquals(sizeBefore + 1, computerManager.getCount());
    }

    @Test
    public void testGetComputersShouldReturnAllComputers() {
        computers.forEach(computerManager::addComputer);

        assertEquals(computers, computerManager.getComputers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWhenExist() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWhenNull() {
        computerManager.addComputer(null);
    }

    @Test
    public void testRemoveComputerShouldRemove() {
        computerManager.addComputer(computer);
        int beforeRemove = computerManager.getCount();
        Computer removed = computerManager.removeComputer(computer.getManufacturer(), computer.getModel());

        assertEquals(beforeRemove - 1, computerManager.getCount());
        assertEquals(computer, removed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerShouldThrowWhenNotExist() {
        computerManager.addComputer(computer);
        computerManager.removeComputer("Not_Existing", "Not_Existing_model");
    }

    @Test
    public void testGetComputersByManufacturer() {
        computers.forEach(computerManager::addComputer);

        List<Computer> byManufacturer = computers.stream()
                .filter(c -> c.getManufacturer().equals(TEST_MANUFACTURER))
                .collect(Collectors.toList());

        assertEquals(byManufacturer, computerManager.getComputersByManufacturer(TEST_MANUFACTURER));
    }
}