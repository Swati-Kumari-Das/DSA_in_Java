// Missing Number - LeetCode #268
// Approach: XOR
// Time Complexity: O(n)
// Space Complexity: O(1)

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Start with n (because range is 0 to n inclusive)
        int xorr = n;
        
        // XOR all indices and numbers
        for (int i = 0; i < n; i++) {
            xorr ^= i ^ nums[i];
        }
        
        // Remaining value is the missing number
        return xorr;
    }
}

/*
Explanation:
---------------
1. XOR cancels out duplicate numbers (a ^ a = 0).
2. If we XOR all indices [0..n-1] with all array elements,
   only the missing number will remain.
3. Example:
   nums = [3, 0, 1], n = 3
   XOR all → 0 ^ 1 ^ 2 ^ 3 ^ 3 ^ 0 ^ 1 = 2 (missing number)
*/
