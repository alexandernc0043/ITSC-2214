int countLeaves(BinaryNode<E> root)
{
	if(root == null) return 0;
	if(root.getLeft() == null && root.getRight() == null) return 1 + countLeaves(root.getLeft()) + countLeaves(root.getRight());
	return 0 + countLeaves(root.getLeft()) + countLeaves(root.getRight());
}

// left = i * 2 + 1
// right = i * 2 + 2
int countLeaves(E[] tree, int node){
	if(tree[node] == null) return 0;
	int left = node * 2 + 1;
	int right = node * 2 + 2;
	if(tree[left] == null && tree[right] == null) {
		return 1 + countLeaves(tree, left) + countLeaves(tree,right);
	}
	return 0 + countLeaves(tree, left) + countLeaves(tree,right);
}