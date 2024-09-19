## Write a binary search algorithm that searches for a particular type of value (possibly using compareTo)
```java
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if target is at mid
        if (arr[mid] == target) {
                return mid;
        }

        // If target is greater, ignore the left half
        if (arr[mid] < target) {
           left = mid + 1;
        }
        // If target is smaller, ignore the right half
        else {
            right = mid - 1;
        }
    }

    // Target not found
    return -1;
    }