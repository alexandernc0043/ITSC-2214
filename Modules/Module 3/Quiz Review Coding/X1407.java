public boolean isLeaf(E[] tree, int node)
{
    return tree[node * 2 + 1] == null && tree[node * 2 + 2] == null;
}
