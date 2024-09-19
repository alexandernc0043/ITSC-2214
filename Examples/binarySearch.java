import java.util.Arrays;
/*
* Explanation:

    1.  binarySearch method: This takes an array arr and the target element to search.
    2.  left and right pointers: These point to the current bounds of the search. The middle element is calculated using (left + (right - left) / 2).
    3.  Comparisons:
        •   If the middle element is the target, return the index.
        •   If the target is larger than the middle element, ignore the left half by updating left.
        •   If the target is smaller, ignore the right half by updating right.
    4.  If the target isn’t found, it returns -1.

This method runs in O(log n) time.
*/
public class BinarySearchExample {

    // Binary Search function
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

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}