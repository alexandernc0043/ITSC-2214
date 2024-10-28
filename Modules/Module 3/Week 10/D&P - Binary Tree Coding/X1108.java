BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode<Integer>(15);
  root.setLeft(new BinaryNode(10));
  root.setRight(new BinaryNode(21));
  BinaryNode<Integer> left = root.getLeft();
  BinaryNode<Integer> right = root.getRight();

  left.setLeft(new BinaryNode(12));
  left.setRight(new BinaryNode(23));

  right.setLeft(new BinaryNode(20));
  right.setRight(new BinaryNode(19));
  return root;
}
