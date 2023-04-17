package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpaceshipTests {

    private static final double OXYGEN_IN_PERCENTAGE = 80;
    private static final int CAPACITY = 100;

    private static final String ASTRONAUT_NAME = "John";
    private static final String SPACESHIP_NAME = "Enterprise";
    private Astronaut astronaut;
    private Spaceship spaceship;

    @Before
    public void setUp() {
        astronaut = new Astronaut(ASTRONAUT_NAME, OXYGEN_IN_PERCENTAGE);
        spaceship = new Spaceship(SPACESHIP_NAME, CAPACITY);
    }

    @Test
    public void testAddAstronautShouldAdd() {
        int sizeBefore = spaceship.getCount();
        spaceship.add(astronaut);

        assertEquals(sizeBefore + 1, spaceship.getCount());
    }

    @Test
    public void testGetAstronautName() {
        assertEquals(SPACESHIP_NAME, spaceship.getName());
    }

    @Test
    public void testGetCapacityShouldReturnSpaceshipCapacity() {
        assertEquals(CAPACITY, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautShouldThrowWhenNoCapacity() {
        Spaceship zeroCapacitySpaceship = new Spaceship("Test", 0);
        zeroCapacitySpaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautShouldThrowIfExist() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testRemoveAstronaut() {
        spaceship.add(astronaut);
        int beforeRemove = spaceship.getCount();
        spaceship.remove(astronaut.getName());

        assertEquals(beforeRemove - 1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIllegalCapacityShouldThrow() {
        new Spaceship("Test", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyNameShouldThrow() {
        new Spaceship(null, 10);
    }
}
