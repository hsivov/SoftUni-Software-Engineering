package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HouseTest {

    private static final String TEST_NAME = "test_name";
    private static final int CAPACITY = 10;

    private Cat cat;
    private House house;

    @Before
    public void setUp() {
        cat = new Cat("Matsa");
        house = new House(TEST_NAME, CAPACITY);
    }

    @Test
    public void testConstructorShouldCreate() {
        House house = new House(TEST_NAME, CAPACITY);

        assertEquals(TEST_NAME, house.getName());
        assertEquals(CAPACITY, house.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWhenNameIsNull() {
        new House(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWhenNameIsEmpty() {
        new House("    ", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWhenCapacityBelowZero() {
        new House(TEST_NAME, -1);
    }

    @Test
    public void testAddCatShouldAdd() {
        int sizeBefore = house.getCount();
        house.addCat(cat);

        assertEquals(sizeBefore + 1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldThrowWhenHouseIsFull() {
        house = new House(TEST_NAME, 0);
        house.addCat(cat);
    }

    @Test
    public void testRemoveCatShouldRemove() {
        house.addCat(cat);

        int sizeBeforeRemove = house.getCount();
        house.removeCat(cat.getName());

        assertEquals(sizeBeforeRemove - 1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldThrowWhenCatNotExist() {
        house.addCat(cat);
        house.removeCat("not_exist");
    }

    @Test
    public void testCatForSaleShouldSetHungryToFalse() {
        house.addCat(cat);
        house.catForSale(cat.getName());

        assertFalse(cat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleShouldThrowWhenCatNotExist() {
        house.addCat(cat);
        house.catForSale("not_exist");
    }
}