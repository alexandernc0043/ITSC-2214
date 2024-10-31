boolean isFull(BinaryNode<E> root)
{	
	if(root == null) return true;
	BinaryNode<E> left = root.getLeft();
  	BinaryNode<E> right = root.getRight();
  	if(left == null && right == null) return true;
  	if(left != null && right != null) return isFull(left) && isFull(right);
  	return false;
}
