import org.junit.*;
import static org.junit.Assert.*;
import itsc2214.*; // not needed now, but you might in your projects

public class ProjectTest {

    /**
     * runner - known as the "test runner" object, this is the
     * object that you will use in testing. You will use this
     * object in each of your tests after reinitializing (new)
     * in the setup() method below.
     */
    private Project runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new Project();
    }

    /**
     * testAdding() testing the only method.
     */
    @Test
    public void testAdding() {
        // Test 1
        assertEquals("Result of the addition is wrong", 15, runner.add5(10));
        // Another test
        assertEquals("Adding negative values is wrong", 0, runner.add5(-5));
    }
}
