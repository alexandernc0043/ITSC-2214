int computeHeight(BinaryNode<E> root) {
    if (root == null) return 0;
    if (root.getLeft() == null && root.getRight() == null) return 0;
    int left = computeHeight(root.getLeft());
    int right = computeHeight(root.getRight());
    if(left > right) return left + 1;
    return right + 1;
    
}