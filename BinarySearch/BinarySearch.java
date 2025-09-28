
// Problem: Binary Search (LeetCode 704)
// Approach: Iterative Binary Search
//
// Explanation:
// 1. Use two pointers `s` (start) and `e` (end) to define the search range.
// 2. Repeatedly calculate the middle index `m = s + (e - s) / 2`.
//    - If nums[m] == target → return m (found).
//    - If nums[m] < target → discard left half → s = m + 1.
//    - If nums[m] > target → discard right half → e = m - 1.
// 3. Continue until s > e. If not found, return -1.
//
// Time Complexity: O(log n) → array is halved each iteration
// Space Complexity: O(1) → constant extra space

class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] == target) {
                return m; // Found target
            } else if (nums[m] < target) {
                s = m + 1; // Search right half
            } else {
                e = m - 1; // Search left half
            }
        }

        return -1; // Not found
    }
}
