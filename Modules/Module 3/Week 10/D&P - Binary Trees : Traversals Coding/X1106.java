boolean isInternal(BinaryNode<E> node)
{
  if(node.getRight() != null || node.getLeft() != null) return true;
  return false;
}
