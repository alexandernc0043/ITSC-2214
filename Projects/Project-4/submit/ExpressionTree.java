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
    private Stack<BinaryNode<String>> stack;
    private boolean parsed = false;
    public ExpressionTree(String postfix) {
        this.postfix = postfix;
    }
    public boolean parse() {
        if (postfix == null){
            return false;
        }
        String[] split = postfix.split("\\s+");
        for (String str : split) {
            if (isNumber(str)) {
                BinaryNode<String> node = new BinaryNode<String>(str, null, null);
                stack.push(node);
            } else if (str == "+" || str == "*" || str == "/" || str == "-" && stack.size() == 2) {
                BinaryNode<String> left = stack.pop();
                BinaryNode<String> right = stack.pop();
                BinaryNode<String> node = new BinaryNode<String>(str, left, right);
                stack.push(node);
            } else {
                return false;
            }
        }
        parsed = true;
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
        if (!parsed || parse() == false) {
            return null;
        }
        return stack.peek();
    }

    public int evaluate() throws ArithmeticException {
        int evalute = 0;

        return evalute;
    }

    public String infixNotation(BinaryNode<String> root) {
        if (root == null)
            return "";
        if (root.getLeft() == null && root.getRight() == null)
            return root.getValue();
        String left = infixNotation(root.getLeft());
        String right = infixNotation(root.getRight());
        return "(" + left + " " + root.getValue() + " " + right + ")";
    }
}
