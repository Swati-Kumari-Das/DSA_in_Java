/**
 * Bubble Sort Algorithm (Optimized)
 *
 * Approach:
 * - Bubble Sort compares adjacent elements and swaps them if they are in the wrong order.
 * - After each pass, the largest element moves to the end (like a bubble rising upwards).
 * - Optimization: If no swap happens in a pass, it means the array is already sorted,
 *   so we break early to avoid unnecessary iterations.
 *
 * Time Complexity:
 * - Best Case: O(n)      -> when array is already sorted
 * - Average:   O(n^2)
 * - Worst:     O(n^2)
 *
 * Space Complexity:
 * - O(1) → Sorting happens in-place (no extra space used)
 */

public class Solution {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swap = false; // flag to check if any swap happened in this pass

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }

            // If no swap occurred, array is sorted → exit early
            if (!swap) break;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr = {5, 2, 9, 1, 5, 6};

        System.out.println("Before Sorting:");
        for (int num : arr) System.out.print(num + " ");

        sol.bubbleSort(arr);

        System.out.println("\n\nAfter Sorting:");
        for (int num : arr) System.out.print(num + " ");
    }
}
