int multiplyNodes(BinaryNode<Integer> root)
{
	int product = root.getValue();
	BinaryNode<Integer> left = root.getLeft();
  	BinaryNode<Integer> right = root.getRight();
	if(right != null) {
		product *= multiplyNodes(right);
	}
	if(left != null){
		product *= multiplyNodes(left);
	}
  	return product;
}
