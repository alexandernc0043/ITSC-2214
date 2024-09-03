public int countNegatives(int[] numbers)
{
  int sum = 0;
    for(int n : numbers)
    {
        if(n < 0) sum += 1;
    }
    return sum;
}

