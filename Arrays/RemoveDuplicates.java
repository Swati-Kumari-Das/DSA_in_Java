/*
 * Problem: Remove Duplicates from Sorted Array
 * 
 * Approach:
 * ----------
 * - Since the array is already sorted, all duplicate elements appear consecutively.
 * - Traverse the array from left to right.
 * - Add the first element to the ArrayList.
 * - For every next element, compare it with the previous one:
 *       - If arr[i] != arr[i - 1], it means this is a distinct element, so add it to the result.
 * - This ensures only unique elements are stored, preserving sorted order.
 *
 * Time Complexity: O(n)
 * ----------------------
 * - We traverse the array only once.
 * - n = number of elements in the input array.
 *
 * Space Complexity: O(n)
 * -----------------------
 * - We store distinct elements in a new ArrayList.
 * - In the worst case (all elements are unique), the list will contain n elements.
 */

import java.util.ArrayList;

public class RemoveDuplicates {

    public ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int n = arr.length;
        if (n == 0) return result;

        // Add the first element
        result.add(arr[0]);
        
        // Add elements that are different from the previous one
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        
        return result;
    }

    // Optional - for testing
    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        
        int[] arr = {1, 1, 2, 2, 3, 4, 4};
        ArrayList<Integer> result = rd.removeDuplicates(arr);
        
        System.out.println(result);
    }
}
