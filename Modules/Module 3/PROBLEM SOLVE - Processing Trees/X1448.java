public BinaryNode<Integer> swapLR(BinaryNode<Integer> root)
{
	if(root == null) return null;
	BinaryNode<Integer> left = root.getLeft();
	BinaryNode<Integer> right = root.getRight();
	root.setRight(left);
	root.setLeft(right);
	swapLR(root.getLeft());
	swapLR(root.getRight());
	return root;
}
