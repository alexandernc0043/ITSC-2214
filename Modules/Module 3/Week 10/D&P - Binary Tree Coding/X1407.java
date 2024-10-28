public boolean isLeaf(E[] tree, int node)
{
    if(node < tree.length) return false;
    if((tree[(node * 2 + 1)] == null) && (tree[(node * 2 + 2)] == null)) return false;
    return true;
}
