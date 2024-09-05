import org.junit.*;
import static org.junit.Assert.*;

/**
 * Class for testing the Bag Class.
 */
public class BagTest {

    /**
     * runner - known as the "test runner" object, this is the
     * object that you will use in testing. You will use this
     * object in each of your tests after reinitializing (new)
     * in the setup() method below.
     */
    private Bag<String> runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new Bag<>();
    }

    /**
     * testInitial() test the initial state of the bag.
     */
    @Test
    public void testInitial() {
        assertTrue(runner.isEmpty());
        assertEquals(0, runner.size());
    }

    /**
     * testAdd() testing adding an element to the bag.
     */
    @Test
    public void testAdd() {
        // Add an element
        runner.add("Hello");
        // Bag is no longer empty, has 1 element
        assertFalse(runner.isEmpty());
        assertEquals(1, runner.size());
        assertTrue(runner.contains("Hello"));
    }

    /**
     * testContains() - check that contains works properly.
     */
    @Test
    public void testContains() {
        assertTrue(runner.add("Hello")); // added one
        assertFalse(runner.isEmpty()); // is not empty
        assertTrue(runner.contains("Hello")); // it is there
        assertFalse(runner.contains("World")); // should not be
    }

    /**
     * testRemove() - test removing an object.
     * 
     * @author mapq
     */
    @Test
    public void testRemove() {
        // Add hello and check it is there
        runner.add("Hello");
        assertTrue(runner.contains("Hello")); // it is there

        // Remove hello and then check is it not and bag is empty
        runner.remove("Hello");
        assertFalse(runner.contains("Hello")); // should not be
        assertTrue(runner.isEmpty());
        assertEquals(0, runner.size());
    }

    /**
     * testIterator() - test that the iterator doesn't return null.
     * 
     * @author mapq
     */
    @Test
    public void testIterator() {
        assertNotNull(runner.iterator());
    }

    /**
     * testClear() - tests that the clear method works.
     * 
     * @author Alexander Prechtel
     */
    @Test
    public void testClear() {
        runner.add("Hello");
        assertTrue(runner.contains("Hello"));
        runner.clear();
        assertTrue(runner.isEmpty());
    }
}
