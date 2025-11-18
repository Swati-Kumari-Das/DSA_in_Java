/**
 * 724. Find Pivot Index
 * 
 * The pivot index is the index where the sum of all the numbers strictly 
 * to the left of the index is equal to the sum of all the numbers strictly 
 * to the right of the index.
 * 
 * If the index is at the extreme left, left sum = 0.
 * If the index is at the extreme right, right sum = 0.
 *
 * Example:
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 *
 * ---------------------------------------------------------
 * Approach:
 * ---------------------------------------------------------
 * 1. First compute the total sum of the array.
 * 2. Maintain a variable `leftSum = 0`.
 * 3. For each index `i`:
 *      - Right sum can be computed as:
 *          rightSum = totalSum - leftSum - nums[i]
 *      - If leftSum == rightSum, this is the pivot index.
 * 4. After checking index i, update:
 *          leftSum += nums[i]
 * 
 * This avoids recomputing left and right sums repeatedly.
 *
 * ---------------------------------------------------------
 * Time Complexity: O(n)
 * We traverse the array twice — one for total sum, one for finding pivot.
 *
 * Space Complexity: O(1)
 * Only a few extra integer variables used.
 * 
 */

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Step 1: Calculate total sum of array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: Traverse array and find pivot
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;  // Pivot found
            }

            leftSum += nums[i];
        }

        return -1;  // No pivot index exists
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        PivotIndex obj = new PivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index: " + obj.pivotIndex(nums));  // Output: 3
    }
}
