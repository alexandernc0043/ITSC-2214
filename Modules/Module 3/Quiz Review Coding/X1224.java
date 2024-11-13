int countInternalNodes(BinaryNode<E> root)
{
	if(root == null) return 0;
	if(root.getLeft() != null || root.getRight() != null) return 1 + countInternalNodes(root.getLeft()) + countInternalNodes(root.getRight());
	return 0 + countInternalNodes(root.getLeft()) + countInternalNodes(root.getRight());
}
