/*
Write the missing base case for function largest. 
Function largest should find the largest number in array numbers. 
When largest is first called, index will equal numbers.length-1.
*/
public int largest(int[] numbers, int index) {
  if(index == 0)
    return numbers[0];
  return Math.max(numbers[index], largest(numbers, index-1));
}
