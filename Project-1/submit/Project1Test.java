import org.junit.*;

import static org.junit.Assert.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.function.*;


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
    private ArrayList<Integer> numbers = new ArrayList<>();

    @Before
    public void setup() {
        // create some data for testing, then
        // initialize your runner object.
        //
        // runner = new Project1<String>( pass some data );

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        runner = new Project1<>(numbers);
    }

    /**
     * testingOne()
     * Tests duplicates
     */
    @Test
    public void testingOne() {
        // Test that runner does not contain duplicates, expected return is false
        assert !runner.hasDuplicates();
    }

    @Test
    public void testingTwo() {
        // Test that it returns the smallest value, expected return is "1"
        assert runner.findSmallest() == 1;
    }

    @Test
    public void testingThree() {
        // Test that it returns the largest value, expected return is "3"
        assert runner.findLargest() == 3;
    }

    @Test
    public void testingFour() {
        // Adds 3 (a duplicate value) to the list of numbers
        numbers.add(3);
        // Assert that it returns true (contains duplicates)
        assert runner.hasDuplicates();
    }
    // Add more tests here. Remember, the goal is to
    // test every method and to execute every line of code
    // in your Project1 class.
}
