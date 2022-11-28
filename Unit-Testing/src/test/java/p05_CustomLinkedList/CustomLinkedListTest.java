package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> linkedList;

    @Before
    public void prepare() {
        linkedList = new CustomLinkedList<>();
        linkedList.add("Ivan");
        linkedList.add("Petkan");
        linkedList.add("Dragan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidationThrowWhenNegativeIndex() {
        linkedList.validateIndex(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidationThrowWhenIndexGreaterThanSize() {
        linkedList.validateIndex(linkedList.getCount());
    }

    @Test
    public void testGetShouldGet() {
        assertEquals("Petkan", linkedList.get(1));
    }

    @Test
    public void testSetShouldSet() {
        linkedList.set(1, "Stoyan");
        assertEquals("Stoyan", linkedList.get(1));
    }

    @Test
    public void testAddShouldAdd() {
        int previousSize = linkedList.getCount();
        linkedList.add("Kaloyan");
        int currentSize = linkedList.getCount();

        assertEquals("Kaloyan", linkedList.get(currentSize - 1));
        assertEquals(previousSize, currentSize - 1);
    }

    @Test
    public void testIndexOfShouldFindIndex () {
        assertEquals(2, linkedList.indexOf("Dragan"));
    }

    @Test
    public void testIndexOfShouldNotFindIndex () {
        assertEquals(-1, linkedList.indexOf("Hristo"));
    }

    @Test
    public void testRemoveAtShouldRemoveItemAtIndex () {
        int sizeBeforeRemove = linkedList.getCount();
        String removed = linkedList.removeAt(0);
        int sizeAfterRemove = linkedList.getCount();

        assertEquals(sizeAfterRemove, sizeBeforeRemove - 1);
        assertEquals("Ivan", removed);
    }

    @Test
    public void testRemoveShouldRemoveItem () {
        int sizeBeforeRemove = linkedList.getCount();
        int indexOfRemoved = linkedList.remove("Ivan");
        int sizeAfterRemove = linkedList.getCount();

        assertEquals(sizeAfterRemove, sizeBeforeRemove - 1);
        assertEquals(0, indexOfRemoved);
        assertEquals(-1, linkedList.remove("Hristo"));
    }

    @Test
    public void testContainsShouldReturnTrue(){
        assertTrue(linkedList.contains("Ivan"));
    }

    @Test
    public void testContainsShouldReturnFalse(){
        assertFalse(linkedList.contains("Dimitar"));
    }
}