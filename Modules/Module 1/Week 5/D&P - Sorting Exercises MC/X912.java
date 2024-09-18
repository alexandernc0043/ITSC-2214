// Return the position of largest number
// in an array of integers
static int largest(int[] nums)
{
    int currlarge = 0; // Pos of largest
    for (int i = 1; i < nums.length; i++) {
        if (nums[currlarge] < nums[i]) {
            currlarge = i;    
        }
    }
    return currlarge;
}

answer = linear time
