int smallest(int[] numbers)
{
    if(numbers.length == 0) return -1;
   int small = numbers[0];
        
        for (int i : numbers) {
            if (i < small) small = i;
        }
        return small;
}

