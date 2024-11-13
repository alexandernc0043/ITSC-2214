boolean isFull(BinaryNode<E> root) {
  if (root == null) return true;
  if (root.getLeft() == null && root.getRight() == null) return true;
  if (root.getLeft() != null && root.getRight() != null) {
    return isFull(root.getLeft()) && isFull(root.getRight());
  }
    return false;
}