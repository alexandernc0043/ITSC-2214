boolean isFull(BinaryNode<E> root)
{
  if(root == null) return false;
  if(root.getLeft() == null && root.getRight() == null) return true;
  return isFull(root.getLeft()) && isFull(root.getRight());
}
