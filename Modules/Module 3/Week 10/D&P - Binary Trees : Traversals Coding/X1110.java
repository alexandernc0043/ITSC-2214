int sumNodes(BinaryNode<Integer> root)
{
	int sum = root.getValue();
	BinaryNode<Integer> left = root.getLeft();
  	BinaryNode<Integer> right = root.getRight();
	if(right != null) {
		sum += sumNodes(right);
	}
	if(left != null){
		sum += sumNodes(left);
	}
  	return sum;
}
