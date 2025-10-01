// Problem: Single Number (LeetCode 136)
// Approach: Bit Manipulation (XOR)
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        // XOR all numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Since every number appears twice except one,
        // pairs cancel out (a ^ a = 0), leaving the unique number.
        return xor;
    }
}

/*
---------------------------------------------------------
Approach Explanation
---------------------------------------------------------
- XOR properties:
  1. a ^ a = 0
  2. a ^ 0 = a
  3. XOR is commutative & associative

- By XOR-ing all numbers:
  → Pairs cancel out (since num ^ num = 0).
  → Only the single (unique) number remains.

Example:
nums = [4, 1, 2, 1, 2]
xor = 0 ^ 4 ^ 1 ^ 2 ^ 1 ^ 2
xor = (4) ^ (1 ^ 1) ^ (2 ^ 2)
xor = 4 ^ 0 ^ 0 = 4

---------------------------------------------------------
Time Complexity:  O(n) → single pass through array
Space Complexity: O(1) → constant extra space
---------------------------------------------------------
*/
