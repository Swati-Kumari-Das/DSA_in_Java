// File: Solution.java
// Problem: Largest Perimeter Triangle (LeetCode 976)
// Approach: Greedy + Sorting
//
// Explanation:
// 1. Sort the array in ascending order.
// 2. The largest perimeter will come from the three largest sides that can form a valid triangle.
// 3. Traverse from the end, and for each triplet (nums[i-2], nums[i-1], nums[i]),
//    check if they satisfy the triangle inequality: a + b > c.
// 4. If valid, return their perimeter. Otherwise, continue checking smaller sides.
// 5. If no valid triangle exists, return 0.
//
// Time Complexity: O(n log n) -> due to sorting
// Space Complexity: O(1) -> in-place sort

import java.util.*;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // Step 1: sort ascending
        int n = nums.length;

        // Step 2: check triplets from largest side backwards
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                // Valid triangle found
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0; // No valid triangle
    }
}
