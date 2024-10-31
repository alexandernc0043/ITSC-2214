public boolean isInternal(E[] tree, int node)
{
    E left = tree[(node * 2) + 1];
    E right = tree[(node * 2) + 2];
    if(left != null || right != null) return true;
    return false;
}
