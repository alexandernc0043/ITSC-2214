BinaryNode<E> add(BinaryNode<E> treeRoot, E node)
{
  if(node.compareTo(treeRoot.getValue()) <= 0){
    if(treeRoot.getLeft() == null){
      treeRoot.setLeft(new BinaryNode(node));  
    } else {
      add(treeRoot.getLeft(), node);
    }
  }
  else {
    if(treeRoot.getRight() == null){
      treeRoot.setRight(new BinaryNode(node));  
    } else {
      add(treeRoot.getRight(), node);
    }
  }
  return treeRoot;
}
