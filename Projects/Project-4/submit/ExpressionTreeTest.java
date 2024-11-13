import org.junit.*;
import static org.junit.Assert.*;
/**
 * Class to test ExpressionTree.
 */
public class ExpressionTreeTest {

    /**
     * runner - known as the "test runner" object, this is the
     * object that you will use in testing. You will use this
     * object in each of your tests after reinitializing (new)
     * in the setup() method below.
     */
    private ExpressionTree runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new ExpressionTree("3 4 +");
    }

    /**
     * Parse Test.
     */
    @Test
    public void testParse() {
        assertTrue(runner.parse());
        runner = new ExpressionTree(null);
        assertFalse(runner.parse());
        runner = new ExpressionTree("+ + +");
        assertFalse(runner.parse());
        runner = new ExpressionTree("+");
        assertFalse(runner.parse());
        runner = new ExpressionTree("3 +");
        assertFalse(runner.parse());
        runner = new ExpressionTree("");
        assertFalse(runner.parse());
        runner = new ExpressionTree("5");
        assertTrue(runner.parse());
        runner = new ExpressionTree("3 4 5 * +");
        assertTrue(runner.parse());
        runner = new ExpressionTree("3 3 3 +");
        assertTrue(runner.parse());
        runner = new ExpressionTree("2 3 + 4 5 * + 5 /");
        assertTrue(runner.parse());
    }
    /**
     * getRoot Test.
     */
    @Test
    public void testGetRoot() {
        assertNull(runner.getRoot());
        runner.parse();
        assertNotNull(runner.getRoot());
        assertEquals("+", runner.getRoot().getValue());
    }
    /**
     * Infix notation test.
     */
    @Test
    public void testInfixNotation() {
        runner.parse();
        assertEquals("(3 + 4)", runner.infixNotation());

        runner = new ExpressionTree("3 4 * 5 +");
        runner.parse();
        assertEquals("((3 * 4) + 5)", runner.infixNotation());

        runner = new ExpressionTree("3 4 5 * +");
        runner.parse();
        assertEquals("(3 + (4 * 5))", runner.infixNotation());

        runner = new ExpressionTree("10");
        runner.parse();
        assertEquals("10", runner.infixNotation());

        runner = new ExpressionTree("2 3 + 4 5 * + 5 /");
        runner.parse();
        assertEquals("(((2 + 3) + (4 * 5)) / 5)", runner.infixNotation());

        runner = new ExpressionTree("9 5 - 2 +");
        runner.parse();
        assertEquals("((9 - 5) + 2)", runner.infixNotation());

        runner = new ExpressionTree("1 2 3 +");
        assertEquals("", runner.infixNotation());
    }
    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate() {
        runner.parse();
        assertEquals(7, runner.evaluate());

        runner = new ExpressionTree("3 4 * 5 +");
        runner.parse();
        assertEquals(17, runner.evaluate());

        runner = new ExpressionTree("3 4 5 * +");
        runner.parse();
        assertEquals(23, runner.evaluate());

        runner = new ExpressionTree("10");
        runner.parse();
        assertEquals(10, runner.evaluate());

        runner = new ExpressionTree("2 3 + 4 5 * + 5 /");
        runner.parse();
        assertEquals(5, runner.evaluate());

        runner = new ExpressionTree("10 5 -");
        runner.parse();
        assertEquals(5, runner.evaluate());

        runner = new ExpressionTree("10 5 -");
        assertEquals(0, runner.evaluate());
    }
    
    /**
     * Tests that evaluate throws an exception with divide by zero.
     */
    @Test(expected = ArithmeticException.class)
    public void testEvaluateTwo() {
        runner = new ExpressionTree("0 0 /");
        runner.parse();
        runner.evaluate();
    }
}
