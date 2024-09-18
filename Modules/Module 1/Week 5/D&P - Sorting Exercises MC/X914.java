static int find(int[] nums, int looking)
{
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == looking)
            return i;
    }
    return -1;
}
answer = Big O(1)
