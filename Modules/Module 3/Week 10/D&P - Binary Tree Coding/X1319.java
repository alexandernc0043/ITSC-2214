BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode(38);
  root.setLeft(new BinaryNode(12));
  root.setRight(new BinaryNode(11));
  root.getRight().setRight(new BinaryNode(91));
  root.getRight().getRight().setRight(new BinaryNode(98));
  return root;
}