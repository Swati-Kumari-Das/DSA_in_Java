/*
 * 🧩 Problem: Pow(x, n)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * 🔹 Approach (Recursive — Fast Exponentiation / Exponentiation by Squaring):
 *
 * 1️⃣ Handle negative powers:
 *     - If n < 0, convert to positive exponent and invert x (x = 1/x, n = -n).
 *
 * 2️⃣ Recursive relation:
 *     - xⁿ = (x^(n/2))²           if n is even
 *     - xⁿ = (x^(n/2))² * x       if n is odd
 *
 * 3️⃣ Base case:
 *     - If n == 0 → return 1.0 (because any number to power 0 is 1)
 *
 * 🔁 Each recursive call divides n by 2 → O(log n) time complexity.
 *
 * 🕒 Time Complexity: O(log n)
 * 🧠 Space Complexity: O(log n)
 *     (due to recursive call stack depth)
 */

public class Solution {
    public double myPow(double x, int n) {
        long exp = n; // Use long to avoid overflow for n = Integer.MIN_VALUE
        if (exp < 0) {
            x = 1 / x;   // Invert base for negative power
            exp = -exp;  // Make exponent positive
        }
        return power(x, exp);
    }

    // Recursive helper using divide & conquer
    private double power(double x, long n) {
        // Base case
        if (n == 0) return 1.0;

        // Recursive case
        double half = power(x, n / 2);

        // If n is even → (x^(n/2))², else multiply one extra x
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    // Optional: For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2.0, 10));   // 1024.0
        System.out.println(sol.myPow(2.1, 3));    // 9.261
        System.out.println(sol.myPow(2.0, -2));   // 0.25
        System.out.println(sol.myPow(-2.0, 3));   // -8.0
    }
}
