/**
 * Problem: Find Minimum in Rotated Sorted Array (LeetCode 153)
 * 
 * You are given an array nums of length n which is sorted in ascending order 
 * and rotated between 1 and n times. Find the minimum element in the array.
 * 
 * Example:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 */

import java.util.*;

public class Solution {

    /**
     * Brute Force Approach
     * --------------------
     * Simply iterate through the array and find the minimum element.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMinBruteForce(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Optimal Approach (Binary Search)
     * --------------------------------
     * Use binary search to reduce the search space.
     * At each step:
     * - If nums[s] <= nums[e], then subarray [s...e] is sorted, so nums[s] is the minimum.
     * - Otherwise, move towards the unsorted half where the minimum must lie.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int minIndex = 0;

        while (s <= e) {
            // Case 1: current range is already sorted
            if (nums[s] <= nums[e]) {
                if (nums[s] < nums[minIndex]) {
                    minIndex = s;
                }
                break;
            }

            int m = s + (e - s) / 2;

            // Case 2: right half is sorted, min lies in left half
            if (nums[m] < nums[e]) {
                minIndex = m;
                e = m - 1;
            } else {
                // Case 3: left half is sorted, min lies in right half
                s = m + 1;
            }
        }

        return nums[minIndex];
    }

    // Driver code for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Brute Force: " + sol.findMinBruteForce(nums1)); // 1
        System.out.println("Optimal: " + sol.findMin(nums1)); // 1

        System.out.println("Brute Force: " + sol.findMinBruteForce(nums2)); // 0
        System.out.println("Optimal: " + sol.findMin(nums2)); // 0

        System.out.println("Brute Force: " + sol.findMinBruteForce(nums3)); // 11
        System.out.println("Optimal: " + sol.findMin(nums3)); // 11
    }
}

