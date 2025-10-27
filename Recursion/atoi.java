/*
 * 🧩 Problem: String to Integer (atoi)
 * 
 * Implement the myAtoi(String s) function, which converts a string to a 32-bit signed integer.
 * 
 * Steps followed (Approach):
 * 1. **Skip Leading Whitespaces:** 
 *    - Ignore all leading spaces in the string.
 * 
 * 2. **Check Sign (+ / -):**
 *    - If the next character is '-' set sign = -1.
 *    - If the next character is '+' set sign = 1.
 *    - Otherwise, assume positive sign.
 * 
 * 3. **Convert Characters to Digits:**
 *    - Read each digit character until a non-digit is found.
 *    - Multiply the result by 10 and add the numeric value of the current digit.
 * 
 * 4. **Handle Overflow:**
 *    - If result * sign exceeds Integer.MAX_VALUE, return Integer.MAX_VALUE.
 *    - If result * sign is less than Integer.MIN_VALUE, return Integer.MIN_VALUE.
 * 
 * 5. **Return Final Result:**
 *    - Multiply the result with the sign and return as integer.
 * 
 * 🕒 Time Complexity: O(n)
 *    - We traverse the string once.
 * 
 * 🧠 Space Complexity: O(1)
 *    - Only a few variables are used (constant space).
 */

public class Solution {
    public int myAtoi(String s) {
        int i = 0;
        long res = 0;
        int sign = 1;

        // 1️⃣ Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return 0;

        // 2️⃣ Check for sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // 3️⃣ Convert digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');

            // 4️⃣ Check for overflow / underflow
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        // 5️⃣ Return final result
        return (int)(sign * res);
    }

    // 🔍 Optional main() for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("42"));             // 42
        System.out.println(sol.myAtoi("   -42"));         // -42
        System.out.println(sol.myAtoi("4193 with words")); // 4193
        System.out.println(sol.myAtoi("words 987"));      // 0
        System.out.println(sol.myAtoi("-91283472332"));   // -2147483648
    }
}
