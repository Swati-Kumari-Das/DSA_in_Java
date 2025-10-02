// Problem: Number of 1 Bits (LeetCode 191)
// Approaches: 
//   1. Bitwise Shift & Check
//   2. Brian Kernighan’s Algorithm (Optimized)


class Solution {

    // Approach 1: Bitwise Shift & Check (Simple, always 32 iterations)
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {   // check all 32 bits
            if (((n >> i) & 1) == 1) {   // isolate i-th bit
                res++;
            }
        }
        return res;
    }

    // Approach 2: Brian Kernighan’s Algorithm (Faster in practice)
    public int hammingWeightOptimized(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);  // removes the lowest set bit
            res++;
        }
        return res;
    }
}

/*
Explanation:
------------
- In binary representation, every number is composed of 0s and 1s.
- The task is to count how many 1s (set bits) are present.

Approach 1 (Bitwise Shift):
- Shift bits one by one and check the least significant bit.
- Always runs 32 iterations regardless of the number of set bits.

Approach 2 (Kernighan’s Algorithm):
- Each iteration removes the lowest set bit.
- Number of iterations = number of set bits in `n`.

Example:
n = 11 (binary 1011)
- Iteration 1: n = 1011 & 1010 = 1010
- Iteration 2: n = 1010 & 1001 = 1000
- Iteration 3: n = 1000 & 0111 = 0000
Result = 3

Complexity:
-----------
Approach 1: Time = O(32) → constant, Space = O(1)
Approach 2: Time = O(k) → k = number of set bits, Space = O(1)
*/
