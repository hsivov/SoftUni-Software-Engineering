package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    private Person pesho = new Person(1, "Pesho");
    private Person gosho = new Person(2, "Gosho");
    private Person tosho = new Person(3, "Tosho");
    private final Person[] PEOPLE = {pesho, gosho, tosho};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructor() {
        Person[] people = database.getElements();
        assertArrayEquals(people, PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtrThrowsWhenMoreThan16Elements() throws OperationNotSupportedException {
        Person[] bigArray = new Person[17];
        new Database(bigArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtrThrowsWhenZeroElements() throws OperationNotSupportedException {
        Person[] zeroArray = new Person[0];
        new Database(zeroArray);
    }

    @Test
    public void testAddPersonToDatabase() throws OperationNotSupportedException {
        Person testPerson = new Person(4, "Ivan");
        database.add(testPerson);

        Person[] databaseElements = database.getElements();
        assertEquals(PEOPLE.length + 1, databaseElements.length);
        assertEquals(testPerson, databaseElements[databaseElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        Person[] peopleBeforeRemove = database.getElements();
        database.remove();
        Person[] peopleAfterRemove = database.getElements();

        Person secondToLast = peopleBeforeRemove[peopleBeforeRemove.length - 2];
        Person currentLast = peopleAfterRemove[peopleAfterRemove.length - 1];

        assertEquals(PEOPLE.length - 1, database.getElements().length);
        assertEquals(currentLast, secondToLast);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWhenEmptyDB() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWhenNullParameter() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWhenUserNotPresent() throws OperationNotSupportedException {
        database.findByUsername("Ivan");
    }

    @Test
    public void testFindByUsernameShouldReturnUser() throws OperationNotSupportedException {
        Person person = database.findByUsername(pesho.getUsername());

        assertEquals(person.getUsername(), pesho.getUsername());
        assertEquals(person.getId(), pesho.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWhenIdNotPresent() throws OperationNotSupportedException {
        database.findById(5);
    }

    @Test
    public void testFindByIdShouldReturnUser() throws OperationNotSupportedException {
        Person person = database.findById(pesho.getId());

        assertEquals(person.getId(), pesho.getId());
    }
}