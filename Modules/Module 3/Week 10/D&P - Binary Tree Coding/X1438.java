public String notation(BinaryNode<Integer> root)
{
    if (root == null)
        return "-";
    else {
        String left = notation(root.getLeft());
        String right = notation(root.getRight());
        if(left == "-" && right == "-"){
            return root.getValue().toString();
        }
        else if(left == "-" || right == "-"){
            return "(" + root.getValue() + " " + left + " " + right + ")";
        }
        return "(" + root.getValue() + " " + left + " " + right + ")";
        // (root left right)
    }
}