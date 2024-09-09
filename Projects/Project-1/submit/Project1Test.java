import org.junit.*;

import static org.junit.Assert.*;

// import java.util.AbstractList;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.function.*;

/**
 * Class for testing Project1 class.
 */
public class Project1Test {

    /**
     * runner - known as the "test runner" object, this is the
     * object that you will use in testing. You will use this
     * object in each of your tests after reinitializing (new)
     * in the setup() method below.
     *
     * For example, if you want to test it with Strings,
     * create an instance like this:
     *
     *  private CollectionUtilities<String> runner;
     */

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    private CollectionUtilities<Integer> runner;
    private Project1<String> collection;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<String> words = new ArrayList<>();
    
    /**
     * Setup function for testing.
     */
    @Before
    public void setup() {
        // create some data for testing, then
        // initialize your runner object.
        //
        // runner = new Project1<String>( pass some data );

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        words.add("aaa");
        words.add("bbbbb");
        words.add("cccc");

        collection = new Project1<>(words);
        runner = new Project1<>(numbers);
    }

    /**
     * testingOne().
     * Tests duplicates
     */
    @Test
    public void testingOne() {
        // Test that runner does not contain duplicates, expected return is false
        assertEquals(false, runner.hasDuplicates());
    }
    
    /**
     * testingTwo().
     * Test that it returns the smallest value, expected return is "1"
     * and that when empty it returns null
     */
    @Test
    public void testingTwo() {
        assertEquals(Integer.valueOf(1), runner.findSmallest());
        numbers.add(0);
        assertEquals(Integer.valueOf(0),runner.findSmallest());
        runner = new Project1<>(new ArrayList<Integer>());
        assertNull(runner.findSmallest());
    }
    
    /**
     * testingThree().
     * Test that it returns the largest value, expected return is "3"
     * and that when empty it returns null
     */
    @Test
    public void testingThree() {
        assertEquals(Integer.valueOf(3), runner.findLargest());
        runner = new Project1<>(new ArrayList<Integer>());
        assertNull(runner.findLargest());
    }
    /**
     * testingFour().
     * Adds 3 (a duplicate value) to the list of numbers
     * Assert that it returns true (contains duplicates)
     */
    @Test
    public void testingFour() {
        numbers.add(3);
        assertTrue(runner.hasDuplicates());
    }
    
    /**
     * testingFive().
     * Tests the findOneThat function
     * Should return "bbbbb" as it's the first string that's length is larger then 4.
     */
    @Test
    public void testingFive() {
        assertEquals("bbbbb", collection.findOneThat(s -> s.length() > 4));
        words.add("ddddd");
        assertEquals("bbbbb", collection.findOneThat(s -> s.length() > 4));
        words.clear();
        words.add("aa");
        assertNull(collection.findOneThat(s -> s.length() > 4));
    }
    /**
     * testingSix().
     * Tests that the filterList function
     * Should return a new collection with only those strings that start with the lower case 'a'
     */
    @Test
    public void testingSix(){
        AbstractList<String> list = collection.filterList(s -> s.charAt(0) == 'a');
        assertTrue(list.get(0).contains("a"));
    }
}
