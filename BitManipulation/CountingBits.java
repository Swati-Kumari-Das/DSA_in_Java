// Problem: Counting Bits (LeetCode 338)
// Approach: Brute Force using Brian Kernighan's Algorithm

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                res[i]++;
                num = num & (num - 1); // remove the lowest set bit
            }
        }

        return res;
    }
}

/*
Explanation:
------------
- For each number from 1 to n, we count its set bits using Brian Kernighan's algorithm.
- num & (num-1) removes the rightmost 1-bit from `num`.
- Keep counting until num becomes 0.

Example:
i = 5 (101)
num = 5 → 4 (100) → 0
count = 2 → so res[5] = 2

Complexity:
-----------
Time: O(n * log n)  → each number takes ~O(#set bits) ≤ O(log n)
Space: O(n)         → output array
*/
