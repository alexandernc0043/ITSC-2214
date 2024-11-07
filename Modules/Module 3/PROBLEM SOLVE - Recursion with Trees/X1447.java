public boolean contains(BinaryNode<E> root, E value)
{
    boolean contains = false;
    if(root == null) return false;
    BinaryNode<E> right = root.getRight();
    BinaryNode<E> left = root.getLeft();
    if(root.getValue().equals(value)) return true;
    return contains || contains(right, value) || contains(left, value);
}
