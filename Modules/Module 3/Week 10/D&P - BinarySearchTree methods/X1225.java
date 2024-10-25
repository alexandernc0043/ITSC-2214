class Binary{
  private BinaryNode<E> root ... // already initialized

  public void add(E node)
  {
    if (node == null)
      return; // do nothing
    else if (root == null)    // first time, just set the root
      root = new BinaryNode<E>(node);
    else
      add(root, node);  // calls your method below
  }
}
//
BinaryNode<E> add(BinaryNode<E> treeRoot, E node)
{
  
}
