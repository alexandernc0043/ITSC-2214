int smallest(int[] numbers)
{
 if(numbers.length == 0) return -1;
        int small = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < small) {
                small = numbers[i];
                index = i;
            }
        }
        return index;
}

