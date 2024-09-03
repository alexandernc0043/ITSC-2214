int largerThan(int[] numbers, int maxVal)
{
    for(int i: numbers){
    if(i > maxVal) return i;
    }
    return maxVal;
}

