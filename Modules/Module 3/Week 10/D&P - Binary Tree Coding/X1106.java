boolean isInternal(BinaryNode<E> node)
{
  if(node.getLeft() != null || node.getRight() != null) return true;
  return false;
}
