public String infixNotation(BinaryNode<String> root)
{
    if(root == null) return "";
    if(root.getLeft() == null && root.getRight() == null) return root.getValue();
    String left = infixNotation(root.getLeft());
    String right = infixNotation(root.getRight());
    return "(" + left + " " + root.getValue() + " " + right + ")";
}
