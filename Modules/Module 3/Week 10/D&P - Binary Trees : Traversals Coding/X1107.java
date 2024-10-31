BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode<>(13);
  root.setLeft(new BinaryNode<Integer>(18));
  root.setRight(new BinaryNode<Integer>(10));
  root.getRight().setRight(new BinaryNode<Integer>(48));

  root.getLeft().setLeft(new BinaryNode<Integer>(19));
  root.getLeft().setRight(new BinaryNode<Integer>(17));
  return root;
}
