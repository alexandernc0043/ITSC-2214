int computeHeight(BinaryNode<E> root)
{
 if(root == null || root != null && root.getLeft() == null && root.getRight() == null) return 0; 
 int sum = 0;
 if(root.getLeft() != null || root.getRight() != null) return 1;
 return computeHeight(root.getLeft()) + computeHeight(root.getRight());
}
