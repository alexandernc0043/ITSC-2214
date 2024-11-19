import itsc2214.*;

import java.util.Stack;

/**
 * ExpressionTree takes a string in postfix notation as an argument to the
 * constructor.
 * This class will store this expression and have methods that process the
 * expression.
 * The expression is readonly, can't be changed and the object of type
 * ExpressionTree will represent that particular expression that is passed as
 * argument to the constructor.
 *
 * @author Alexander Prechtel
 * @version Nov 13, 2024
 */
public class ExpressionTree {

    private String postfix = null;
    private BinaryNode<String> root;

    private boolean parsed = false;

    /**
     * Constructor.
     * 
     * @param postfix notation.
     */
    public ExpressionTree(String postfix) {
        this.postfix = postfix;
    }

    /**
     * Method that parses the postfix returning true if the expression is in valid
     * postfix notation (more on that below).
     * If the expression is valid, the routine,
     * internally should build a BinaryNode<String> tree and store the root in an
     * instance variable.
     * 
     * @return boolean if parsing was successful
     */
    public boolean parse() {
        Stack<BinaryNode<String>> stack = new Stack<>();
        if (postfix == null) {
            return false;
        }
        String[] split = postfix.split("\\s+"); // Splits the string (postfix) by spaces "\\s+"
        for (String str : split) {
            // if it's a number
            if (isNumber(str)) {
                BinaryNode<String> node = new BinaryNode<String>(str, null, null);
                stack.push(node);
                // if it's an operation and the stack size is 2
            } else if (isOperator(str) && stack.size() >= 2) {
                BinaryNode<String> right = stack.pop(); // get the right value
                BinaryNode<String> left = stack.pop(); // get the left value
                // make a new node that has root, left, and right.
                BinaryNode<String> node = new BinaryNode<String>(str, left, right);
                stack.push(node);
            } else {
                return false;
            }
        }
        if (stack.size() > 1) { // if stack is greater then 1 make a new node
            // With left side null.
            // And with right side not null.
            BinaryNode<String> right = stack.pop();
            BinaryNode<String> root = stack.pop();
            stack.push(new BinaryNode<String>(root.getValue(), null, right));
        }
        root = stack.pop();
        parsed = true;
        return true;
    }

    /**
     * Determines if the string is a number.
     * Takes string as input and will throw an,
     * NumberFormatException if the string is not an integer.
     * 
     * @param str Thing to evaluate.
     * @return boolean is a number
     */
    private boolean isNumber(String str) {
        return str.matches("[0-9]+");
    }

    /**
     * Determines if the string is a operator.
     * 
     * @param str Thing to evaluate
     * @return boolean is a operator
     */
    private boolean isOperator(String str) {
        return str.matches("[*/+-]");
    }

    /**
     * Returns the root of the tree or null if either the tree hasn't been built yet
     * (i.e., parse() has not been called) or if parse(),
     * Returns false negative and thus there is no tree.
     * 
     * @return BinaryNode<String> root
     */
    public BinaryNode<String> getRoot() {
        if (!parsed) {
            return null;
        }
        return root;
    }

    /**
     * Method evaluates the tree stored internally and returns an integer
     * representing the value of the expression.
     * The expression should support addition (+), multiplication (*),
     * subtraction (-) and division (/).
     * 
     * @throws ArithmeticException (Divide by 0)
     * @return int evaluated the equation.
     */
    public int evaluate() throws ArithmeticException {
        if (!parsed)
            return 0;
        return traverse(root);
    }

    /**
     * Travseres the node / tree its given and returns the evaluation, used in
     * evaluate().
     * 
     * @param node BinaryNode<String>
     * @return int evaluted.
     */
    public int traverse(BinaryNode<String> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return Integer.parseInt(node.getValue());
        }
        int left = traverse(node.getLeft());
        int right = traverse(node.getRight());
        String root = node.getValue();
        int value = 0;
        switch (root) {
            case "+":
                value = left + right;
                break;
            case "-":
                value = left - right;
                break;
            case "*":
                value = left * right;
                break;
            case "/":
                if (right == 0)
                    throw new ArithmeticException("Divide by zero error.");
                value = left / right;
                break;
        }
        return value;
    }

    /**
     * Return an infix notation with parenthesis to enforce order of operations.
     * The terminal nodes of the tree contain values (i.e., number) and thus should
     * not be wrapped in parenthesis.
     * But all other subtrees should be turned into a parenthesized expression.
     * This is in effect an in-order traversal of the tree.
     * 
     * @return String infix notation.
     */
    public String infixNotation() {
        if (!parsed)
            return null; // if not parsed return null.
        return infixNotationMaker(root);
    }
    
    /**
     * Makes infix notation using recursion on the tree created from the parse method.
     * @param node BinaryNode<String>
     * @return String infix
     */
    public String infixNotationMaker(BinaryNode<String> node) {
        String root = node.getValue();
        if (node.getLeft() == null && node.getRight() == null) {
            return root;
        }
        String left = infixNotationMaker(node.getLeft());
        String right = infixNotationMaker(node.getRight());

        return "(" + left + " " + root + " " + right + ")";

    }
}
