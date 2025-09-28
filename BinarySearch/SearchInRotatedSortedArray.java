// Problem: Search in Rotated Sorted Array (LeetCode 33)
// Approach: Modified Binary Search

class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            // Case 1: Target found
            if (nums[m] == target) {
                return m;
            }

            // Case 2: Left half is sorted
            if (nums[s] <= nums[m]) {
                if (nums[s] <= target && target < nums[m]) {
                    e = m - 1; // search in left half
                } else {
                    s = m + 1; // search in right half
                }
            } 
            // Case 3: Right half is sorted
            else {
                if (nums[m] < target && target <= nums[e]) {
                    s = m + 1; // search in right half
                } else {
                    e = m - 1; // search in left half
                }
            }
        }

        return -1; // target not found
    }
}

/*
Approach:
- The array is rotated but still partially sorted.
- At each step, one half (left or right) is guaranteed to be sorted.
- Use binary search logic to decide which half to search:
  1. If target lies in the sorted half → search that half.
  2. Else → search the other half.
- Repeat until the target is found or search space is empty.

Time Complexity: O(log n) → Binary search on rotated array
Space Complexity: O(1)   → Constant extra space
*/
