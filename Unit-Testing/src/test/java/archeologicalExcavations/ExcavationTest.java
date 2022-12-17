package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class ExcavationTest {

    private static final String TEST_NAME = "test_name";
    private static final int CAPACITY = 10;
    private Collection<Archaeologist> archaeologists;
    private Archaeologist archaeologist;
    private Excavation excavation;

    @Before
    public void setUp() {
        archaeologists = new ArrayList<>();
        archaeologist = new Archaeologist(TEST_NAME, 45);
        excavation = new Excavation(TEST_NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWhenNameIsNull() {
        new Excavation(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowWhenNameIsEmpty() {
        new Excavation("    ", CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWhenNegativeCapacity() {
        new Excavation(TEST_NAME, -1);
    }

    @Test
    public void testConstructorShouldCreateNewObject() {
        assertEquals(TEST_NAME, excavation.getName());
        assertEquals(CAPACITY, excavation.getCapacity());
    }

    @Test
    public void testAddArchaeologistShouldAddToCollection() {
        int sizeBeforeAdd = archaeologists.size();
        excavation.addArchaeologist(archaeologist);

        assertEquals(sizeBeforeAdd + 1, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowWhenNoMoreCapacity() {
        excavation = new Excavation(TEST_NAME, 0);

        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistShouldThrowWhenArchaeologistExist() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testRemoveArchaeologistShouldRemoveFromList() {
        excavation.addArchaeologist(archaeologist);

        assertTrue(excavation.removeArchaeologist(archaeologist.getName()));
    }
}