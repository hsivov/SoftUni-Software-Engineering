package carShop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class CarShopTests {

    private CarShop carShop;
    private Car car;
    private List<Car> cars;
    private static final String TEST_NAME = "Tesla";
    private static final int TEST_HP = 240;
    private static final double TEST_PRICE = 112900;

    @Before
    public void setUp() {
        car = new Car(TEST_NAME, TEST_HP, TEST_PRICE);
        carShop = new CarShop();
        cars = List.of(
                new Car("BMW", 185, 49900),
                new Car("Ford", 116, 24500),
                new Car("Opel", 87, 32000)
        );
    }

    @Test
    public void testGetCarsShouldReturnAllCars() {
        cars.forEach(carShop::add);

        assertEquals(cars, carShop.getCars());
    }

    @Test
    public void testGetCountShouldReturnCarsCount() {
        int sizeBefore = carShop.getCount();
        carShop.add(car);

        assertEquals(sizeBefore + 1, carShop.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxHorsePower() {
        cars.forEach(carShop::add);
        List<Car> powerCars = carShop.findAllCarsWithMaxHorsePower(180);

        assertEquals(1, powerCars.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullCarShouldThrow() {
        carShop.add(null);
    }

    @Test
    public void testRemoveCarShouldRemove() {
        carShop.add(car);
        int beforeRemove = carShop.getCount();
        carShop.remove(car);

        assertEquals(beforeRemove - 1, carShop.getCount());
    }

    @Test
    public void testGetTheMostLuxuryCar() {
        cars.forEach(carShop::add);
        Car mostLuxury = carShop.getTheMostLuxuryCar();

        assertEquals("BMW", mostLuxury.getModel());
    }

    @Test
    public void testFindAllCarByModel() {
        cars.forEach(carShop::add);
        List<Car> carsByModel = carShop.findAllCarByModel("Opel");

        assertEquals(1, carsByModel.size());
    }
}

