package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {2, 3, 7, 9};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructor() {
        Integer[] dbElements = database.getElements();
        assertArrayEquals(NUMBERS, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtrThrowsWhenMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtrThrowsWhenZeroElements() throws OperationNotSupportedException {
        Integer[] zeroArray = new Integer[0];
        new Database(zeroArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtrThrowsWhenReceiveNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddElement() throws OperationNotSupportedException {
        Integer testValue = 42;
        database.add(testValue);
        Integer[] dbElements = database.getElements();

        assertEquals(testValue, dbElements[dbElements.length - 1]);
        assertEquals(NUMBERS.length + 1, dbElements.length);
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        Integer[] elementsBeforeRemove = database.getElements();
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();

        int previousSecondToLastElement = elementsBeforeRemove[elementsBeforeRemove.length - 2];
        int currentLastElement = elementsAfterRemove[elementsAfterRemove.length - 1];

        assertEquals(NUMBERS.length - 1, elementsAfterRemove.length);
        assertEquals(previousSecondToLastElement, currentLastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowsWhenEmptyDB() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}