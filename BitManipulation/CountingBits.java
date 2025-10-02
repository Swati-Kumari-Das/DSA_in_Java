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

// Problem: Counting Bits (LeetCode 338)
// Approach: Dynamic Programming + Bit Manipulation

public class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        // dp[i] = dp[i >> 1] + (i & 1)
        // Explanation:
        //   - (i >> 1): same as dividing i by 2, dropping the last bit
        //   - (i & 1): checks if the last bit of i is 1
        // So, number of 1s in i = number of 1s in i/2 + last_bit
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }
}

/*
Example:
n = 5
dp[0] = 0
dp[1] = dp[0] + 1 = 1
dp[2] = dp[1] + 0 = 1
dp[3] = dp[1] + 1 = 2
dp[4] = dp[2] + 0 = 1
dp[5] = dp[2] + 1 = 2
Output = [0, 1, 1, 2, 1, 2]

Time Complexity: O(n)   → Each number computed in O(1)
Space Complexity: O(n)  → Storing results in dp array
*/
