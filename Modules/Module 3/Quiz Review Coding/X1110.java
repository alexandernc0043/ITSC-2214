int sumNodes(BinaryNode<Integer> root)
{
  int sum = 0;
  if(root == null) return 0;
  sum += root.getValue();
  sum += sumNodes(root.getLeft()) + sumNodes(root.getRight());
  return sum;
}
