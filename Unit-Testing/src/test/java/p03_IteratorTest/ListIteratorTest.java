package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] NAMES = {"Pesho", "Gosho", "Tosho"};

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtrThrowWhenPassedNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructor() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(NAMES);
        assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        assertEquals(NAMES[1], listIterator.print());
        listIterator.move();
        assertEquals(NAMES[2], listIterator.print());
    }

    @Test
    public void testHasNext() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowWhenIteratorEmpty() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrint() {
        assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        assertEquals(NAMES[1], listIterator.print());
    }
}