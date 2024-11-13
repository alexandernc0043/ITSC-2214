import itsc2214.*;

import java.util.Objects;
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
    private Stack<BinaryNode<String>> stack = new Stack<>();
    private boolean parsed = false;

    /**
     * Constructor
     * 
     * @param String postfix notaiton
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
        if (postfix == null) {
            return false;
        }
        String[] split = postfix.split("\\s+");
        for (String str : split) {
            if (isNumber(str)) {
                BinaryNode<String> node = new BinaryNode<String>(str, null, null);
                stack.push(node);
            } else if (isOperator(str) && stack.size() == 2) {
                BinaryNode<String> right = stack.pop();
                BinaryNode<String> left = stack.pop();
                BinaryNode<String> node = new BinaryNode<String>(str, left, right);
                stack.push(node);
            } else {
                return false;
            }
        }
        parsed = true;
        return true;
    }

    /**
     * Determines if the string is a number.
     * 
     * @param String str
     * @return boolean is a number
     */
    boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Determines if the string is a operator.
     * 
     * @param String str
     * @return boolean is a operator
     */
    boolean isOperator(String str) {
        return Objects.equals(str, "+") || Objects.equals(str, "-") || Objects.equals(str, "*")
                || Objects.equals(str, "/");
    }

    /**
     * Returns the root of the tree or null if either the tree hasn't been built yet
     * (i.e., parse() has not been called) or if parse(),
     * Returns false negative and thus there is no tree.
     * 
     * @return BinaryNode<String> root
     */
    public BinaryNode<String> getRoot() {
        if (!parsed || !parse()) {
            return null;
        }
        return stack.peek();
    }

    /**
     * Method evaluates the tree stored internally and returns an integer
     * representing the value of the expression.
     * The expression should support addition (+), multiplication (*), subtraction
     * (-) and division(/).
     * 
     * @throws ArithmeticException (Divide by 0)
     */
    public int evaluate() throws ArithmeticException {
        try {
            return 0; // TODO
        } catch (Exception e) {
            throw new ArithmeticException(e.getMessage());
        }
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
        BinaryNode<String> root = getRoot();
        if (root == null)
            return "";
        if (root.getLeft() == null && root.getRight() == null)
            return root.getValue();
        /*
         * String left = infixNotation(root.getLeft());
         * String right = infixNotation(root.getRight());
         * return "(" + left + " " + root.getValue() + " " + right + ")";
         */
        return " "; // TODO
    }
}
