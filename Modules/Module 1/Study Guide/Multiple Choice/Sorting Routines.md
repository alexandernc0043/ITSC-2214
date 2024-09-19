## Bubble Sort

Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the input list element by element, comparing the current element with the one after it, swapping their values if needed. These passes through the list are repeated until no swaps have to be performed during a pass, meaning that the list has become fully sorted. The algorithm, which is a comparison sort, is named for the way the larger elements "bubble" up to the top of the list.

## Insertion Sort
Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time by comparisons. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. However, insertion sort provides several advantages:


1. Simple implementation: Jon Bentley shows a version that is three lines in C-like pseudo-code, and five lines when optimized.[1]
2. Efficient for (quite) small data sets, much like other quadratic (i.e., O(n2)) sorting algorithms
3. More efficient in practice than most other simple quadratic algorithms such as selection sort or bubble sort
4. Adaptive, i.e., efficient for data sets that are already substantially sorted: the time complexity is O(kn) when each element in the input is no more than k places away from its sorted position
5. Stable; i.e., does not change the relative order of elements with equal keys
6. In-place; i.e., only requires a constant amount O(1) of additional memory space
7. Online; i.e., can sort a list as it receives it
