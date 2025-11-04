/**
 * Selection Sort Algorithm
 *
 * Approach:
 * - For each position i in the array, assume it is the minimum
 * - Search the remaining part of array to find the true minimum element
 * - Swap the minimum element with the element at index i
 * - Continue until array is sorted
 *
 * Time Complexity:
 * - Best: O(n^2)
 * - Average: O(n^2)
 * - Worst: O(n^2)
 *
 * Space Complexity:
 * - O(1) (In-place sorting, no extra memory used)
 *
 * Note:
 * - Selection sort is not stable (order of equal elements may change)
 * - Good for small input size and understanding sorting concept
 */

public class Solution {

    void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap smallest found element with current index
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Driver code to test functionality
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Before Sorting:");
        for (int val : arr) System.out.print(val + " ");

        sol.selectionSort(arr);

        System.out.println("\n\nAfter Sorting:");
        for (int val : arr) System.out.print(val + " ");
    }
}
