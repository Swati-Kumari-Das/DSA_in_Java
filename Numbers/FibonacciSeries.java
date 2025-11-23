/**
 * FibonacciSeries.java
 *
 * This file contains the Solution class implementing the Fibonacci series
 * generation up to the nth term (0-based indexing) using modulo 1e9+7.
 * Suitable for uploading directly to GitHub.
 */

/**
 * APPROACH:
 * We need to generate Fibonacci numbers from index 0 to n.
 * Fibonacci rules:
 *    f[0] = 0
 *    f[1] = 1
 *    f[i] = f[i-1] + f[i-2]
 * Since values can become large, each addition is taken modulo 1e9+7.
 * We store all terms in an array of size n+1.
 *
 * TIME COMPLEXITY:
 *    O(n) → We compute each Fibonacci number once in a loop.
 *
 * SPACE COMPLEXITY:
 *    O(n) → We return an array storing all Fibonacci terms from 0 to n.
 */
class Solution {

    int[] Series(int n) {
        int mod = 1000000007;
        int[] arr = new int[n + 1];

        // Base cases
        arr[0] = 0;
        if (n >= 1) arr[1] = 1;

        // Generate Fibonacci series
        for (int i = 2; i <= n; i++) {
            arr[i] = (int)((arr[i - 1] + (long)arr[i - 2]) % mod);
        }

        return arr;
    }

    // Optional main() for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;
        int[] result = sol.Series(n);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
