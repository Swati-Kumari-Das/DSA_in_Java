/*
 * Problem: 442. Find All Duplicates in an Array
 * Difficulty: Medium
 *
 * Description:
 * ------------
 * You are given an integer array nums of length n.
 * Each element appears once or twice.
 * You must return all elements that appear exactly twice.
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 100000
 * - 1 <= nums[i] <= n
 * - You must solve it in O(n) time and O(1) extra space 
 *   (excluding output list).
 *
 *
 * Approach (Index Marking / Sign-Flipping Trick):
 * -----------------------------------------------
 * Since all values lie within [1, n], each number corresponds to
 * an index in the array (value x corresponds to index x - 1).
 *
 * Steps:
 * 1. For each number 'x', map it to index = abs(x) - 1.
 * 2. If nums[index] is positive, flip it to negative to mark "visited".
 * 3. If nums[index] is already negative, it means this number has 
 *    appeared before → it's a duplicate → add abs(x) to result.
 *
 * Why this works:
 * - We use the sign of nums[index] as a marker.
 * - No extra space is used (ignoring output).
 * - Modifying nums[] is allowed.
 *
 *
 * Time Complexity: O(n)
 * ---------------------
 * We traverse the array once.
 *
 *
 * Space Complexity: O(1)
 * ----------------------
 * We only modify the original array and use constant extra space.
 */

import java.util.*;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;  // map value to index

            // If already visited → duplicate found
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                // Mark index visited by flipping sign
                nums[index] = -nums[index];
            }
        }

        return result;
    }

    // Optional main() for testing
    public static void main(String[] args) {
        FindAllDuplicates obj = new FindAllDuplicates();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(obj.findDuplicates(nums)); // Output: [2, 3]
    }
}
