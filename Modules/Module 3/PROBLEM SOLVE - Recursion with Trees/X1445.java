public int multiplyNodes(BinaryNode<Integer> root)
{
    int sum = 1;
    if(root == null) return 1;
    BinaryNode<Integer> right = root.getRight();
    BinaryNode<Integer> left = root.getLeft();
    sum *= root.getValue();
    return sum * multiplyNodes(right) * multiplyNodes(left);
}
