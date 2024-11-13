int countLeaves(BinaryNode<E> root)
{
	if(root == null) return 0;
	if(root.getLeft() == null && root.getRight() == null) return 1 + countLeaves(root.getLeft()) + countLeaves(root.getRight());
	return 0 + countLeaves(root.getLeft()) + countLeaves(root.getRight());
}
