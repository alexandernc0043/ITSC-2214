int multiplyNodes(BinaryNode<Integer> root)
{
  int sum = 1;
  if(root == null) return 1;
  sum *= root.getValue();
  sum *= multiplyNodes(root.getLeft()) * multiplyNodes(root.getRight());
  return sum;
}
