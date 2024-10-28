BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode<Integer>(13);
  root.setLeft(new BinaryNode(18));
  root.getLeft().setLeft(new BinaryNode(19));
  root.getLeft().setRight(new BinaryNode(17));
  root.setRight(new BinaryNode(10));
  root.getRight().setRight(new BinaryNode(48));
  return root;
}
