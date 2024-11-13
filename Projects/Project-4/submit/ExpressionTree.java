import itsc2214.*;
import java.util.Stack;
/**
 * TODO Write a one-sentence summary of your class here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author  Alexander Prechtel
 * @version Nov 13, 2024
 */
public class ExpressionTree {
    private String postfix = null;
    private BinaryNode<String> tree;
    private Stack<BinaryNode<String>> stack;

    public ExpressionTree(String postfix) {
        this.postfix = postfix;
    }

    public boolean parse() {
        if (postfix == null)
            return false;
        String[] split = postfix.split("\\s+");
        for (String str : split) {
            if (isNumber(str)) {
                BinaryNode<String> node = new BinaryNode<String>(str, null, null);
                stack.push(node);
            } else if (str == "+" || str == "*" || str == "/") {

            } else {
                return false;
            }
        }
        return true;
    }

    boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }

    public BinaryNode<String> getRoot() {
        return tree;
    }

    public int evaluate() throws ArithmeticException {

    }

    public String infixNotation() {
        
    }
}
