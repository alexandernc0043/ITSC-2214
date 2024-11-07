public int findMax(BinaryNode<Integer> root)
{
    int max = 0;
    if(root == null) return max;
    BinaryNode<Integer> right = root.getRight();
    BinaryNode<Integer> left = root.getLeft();
    if(root.getValue() > max) max = root.getValue();
    int rMax = findMax(right);
    int lMax = findMax(left);
    if(rMax > max) max = rMax;
    if(lMax > max) max = lMax;
    return max;
}
