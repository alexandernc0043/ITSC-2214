BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode<Integer>(38);
  root.setLeft(new BinaryNode<Integer>(12));
  root.setRight(new BinaryNode<Integer>(11));
  root.getRight().setRight(new BinaryNode<Integer>(91));
  root.getRight().getRight().setRight(new BinaryNode<Integer>(98));
  return root;
}
