// Problem: Find Minimum in Rotated Sorted Array (LeetCode 153)
// Approach: Binary Search
class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int minIndex = 0;

        while (s <= e) {
            // Case 1: Current subarray is already sorted
            if (nums[s] <= nums[e]) {
                if (nums[s] < nums[minIndex]) {
                    minIndex = s;
                }
                break;
            }

            int m = s + (e - s) / 2;

            // Case 2: Minimum lies in the left half
            if (nums[m] < nums[e]) {
                minIndex = m;
                e = m - 1;
            } 
            // Case 3: Minimum lies in the right half
            else {
                s = m + 1;
            }
        }

        return nums[minIndex];
    }
}

/*
Time Complexity: O(log n)  → Binary search on the array
Space Complexity: O(1)    → Constant extra space
*/
