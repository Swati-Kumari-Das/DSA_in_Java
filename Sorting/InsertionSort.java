/**
 * Insertion Sort Algorithm (Swap-Based)
 *
 * Approach:
 * - Start from index 1 and pick each element (like sorting playing cards)
 * - Compare it with previous elements
 * - Swap backwards until it reaches its correct position
 *
 * Time Complexity:
 * - Best Case: O(n)     -> when array is already sorted
 * - Average:   O(n^2)
 * - Worst:     O(n^2)
 *
 * Space Complexity:
 * - O(1) -> In-place sorting
 *
 * Note:
 * This is a swap-based implementation of insertion sort.
 * It repeatedly swaps elements until they are in correct order.
 */

public class Solution {

    // Please change the array in-place
    public void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                // swap arr[j-1] and arr[j]
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    // Driver code to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {5, 2, 9, 1, 3};

        System.out.println("Before Sorting:");
        for (int num : arr) System.out.print(num + " ");

        sol.insertionSort(arr);

        System.out.println("\n\nAfter Sorting:");
        for (int num : arr) System.out.print(num + " ");
    }
}
