int countNodes(BinaryNode<String> root)
{
  if(root == null) return 0;
  return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
}
