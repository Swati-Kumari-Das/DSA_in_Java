/*
 * Problem: Maximum Product Subarray
 * Difficulty: Medium
 *
 * Description:
 * ------------
 * Given an integer array arr[], the task is to find the contiguous subarray 
 * within the array that has the maximum product. 
 *
 * Example:
 * Input: [2, 3, -2, 4]
 * Output: 6
 *
 * Explanation:
 * The subarray [2,3] has the maximum product 6.
 *
 *
 * Approach:
 * ---------
 * We maintain two running products:
 *
 * 1. LtoR (Left to Right product)
 * 2. RtoL (Right to Left product)
 *
 * Why?
 * - Because negative numbers can flip the sign of the product.
 * - Reset the product to 1 whenever we hit zero.
 * - Track the maximum of all products seen.
 *
 * This avoids the need for complex max/min tracking logic and still ensures 
 * we check all possible subarrays through forward and backward passes.
 *
 *
 * Time Complexity: O(n)
 * ----------------------
 * Only one pass from left and right together.
 *
 *
 * Space Complexity: O(1)
 * -----------------------
 * Constant extra space.
 */

public class MaxProductSubarray {

    public int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProd = Integer.MIN_VALUE;

        int LtoR = 1;
        int RtoL = 1;

        for (int i = 0; i < n; i++) {

            // Reset for left-to-right
            if (LtoR == 0)
                LtoR = 1;

            // Reset for right-to-left
            if (RtoL == 0)
                RtoL = 1;

            LtoR *= arr[i];
            RtoL *= arr[n - i - 1];

            maxProd = Math.max(maxProd, Math.max(LtoR, RtoL));
        }

        return maxProd;
    }

    // Optional main for testing
    public static void main(String[] args) {
        MaxProductSubarray obj = new MaxProductSubarray();

        int[] arr = {2, 3, -2, 4};
        System.out.println(obj.maxProduct(arr));  // Output: 6
    }
}
