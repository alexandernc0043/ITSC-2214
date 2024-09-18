static int duplicates(int[] nums)
{
    int dups = 0;
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i != j) // we ignore it
                if (nums[i] == nums[j])
                    dups++;
        }
    }
    return dups;
}
answer = The growth rate for this algorithm is Big O(N^2)
