BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode(15);
  root.setLeft(new BinaryNode(10));
  root.setRight(new BinaryNode(21));

  root.getLeft().setLeft(new BinaryNode(12));
  root.getLeft().setRight(new BinaryNode(23));

  root.getRight().setLeft(new BinaryNode(20));
  root.getRight().setRight(new BinaryNode(19));
  return root;
}
