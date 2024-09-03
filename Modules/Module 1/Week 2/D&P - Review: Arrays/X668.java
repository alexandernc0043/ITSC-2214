int[] createArray(int size, int initial)
{
  		int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = initial;
        }
        return array;
}

