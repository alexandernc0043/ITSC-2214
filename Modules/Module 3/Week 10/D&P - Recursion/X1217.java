public int padovanSequence(int n)
{
    if(n == 0 || n == 1 || n == 2) return 1;
    return padovanSequence(n-2) + padovanSequence(n-3);
}
