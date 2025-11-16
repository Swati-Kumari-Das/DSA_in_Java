/*
 * Problem: Remove Duplicates from Unsorted Array
 *
 * Approach:
 * ----------
 * - Use a HashSet to track elements already seen.
 * - Traverse the array and for every element:
 *        - If it is not present in the HashSet, add it to both the HashSet and the result list.
 *        - If it is already present, skip it.
 * - This ensures first occurrences are kept and duplicates are removed.
 *
 * Time Complexity: O(n)
 * ----------------------
 * - Each element is inserted and searched in HashSet in O(1) average time.
 *
 * Space Complexity: O(n)
 * -----------------------
 * - HashSet + ArrayList store unique elements.
 */

import java.util.*;

public class Solution {

    static ArrayList<Integer> removeDuplicate(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }

        return result;
    }

    // Optional testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 2};
        System.out.println(removeDuplicate(arr));  // Output: [1, 2, 3, 4]
    }
}
