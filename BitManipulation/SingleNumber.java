// Problem: Single Number (LeetCode 136)
// Approach: HashSet

import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                // If already present, remove (since it's a duplicate)
                seen.remove(num);
            } else {
                // If not present, add to set
                seen.add(num);
            }
        }

        // Only one element will remain in the set
        return seen.iterator().next();
    }
}

/*
---------------------------------------------------------
Approach Explanation
---------------------------------------------------------
- Use a HashSet to track elements:
  - If a number is seen for the first time → add it.
  - If seen again → remove it.
- Since every number except one appears twice,
  all pairs get removed, and the unique element remains.

Example:
nums = [4, 1, 2, 1, 2]
Iteration:
  seen = {4}
  seen = {4, 1}
  seen = {4, 1, 2}
  seen = {4, 2} (1 removed)
  seen = {4}    (2 removed)

Answer = 4

---------------------------------------------------------
Time Complexity:  O(n) → iterate through array once
Space Complexity: O(n) → extra HashSet to store elements
---------------------------------------------------------
*/


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
