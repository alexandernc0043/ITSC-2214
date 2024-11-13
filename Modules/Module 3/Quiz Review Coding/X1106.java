boolean isInternal(BinaryNode<E> node)
{
  return node.getLeft() != null || node.getRight() != null;
}
