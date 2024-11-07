public int sumNodes(BinaryNode<Integer> root)
{
    int sum = 0;
    if(root == null) return 0;
    BinaryNode<Integer> right = root.getRight();
    BinaryNode<Integer> left = root.getLeft();
    sum += root.getValue();
    return sum + sumNodes(right) + sumNodes(left);
}
