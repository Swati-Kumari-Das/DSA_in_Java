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

/*
 * 🧩 Problem: String to Integer (atoi) — Recursive Approach
 *
 * Implement the myAtoi(String s) function recursively.
 *
 * 🔹 Approach:
 * The recursive version breaks down the iterative process into smaller steps.
 *
 * 1️⃣ Skip leading whitespaces:
 *     - Move index forward until a non-space is found.
 *
 * 2️⃣ Detect sign (+ or -):
 *     - If current char is '-', sign = -1; if '+', sign = 1.
 *
 * 3️⃣ Recursive conversion:
 *     - Base case: stop if index >= length or char is not a digit.
 *     - Recursive case: 
 *           res = res * 10 + current_digit
 *           call helper(s, next_index, res, sign)
 *
 * 4️⃣ Overflow check:
 *     - Before each recursive call, check if sign * res exceeds 32-bit range.
 *
 * 5️⃣ Return result:
 *     - Once base condition reached, return (int)(sign * res)
 *
 * 🕒 Time Complexity: O(n)
 *     - Each character is processed once recursively.
 *
 * 🧠 Space Complexity: O(n)
 *     - Due to recursion call stack (worst-case all characters are digits).
 */

public class RecursiveAtoi {

    public int myAtoi(String s) {
        int i = 0;

        // 1️⃣ Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return 0;

        // 2️⃣ Detect sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // 3️⃣ Start recursive helper
        return helper(s, i, 0L, sign);
    }

    // 🔁 Recursive helper function
    private int helper(String s, int i, long res, int sign) {
        // Base case: stop if not a digit or end of string
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign * res);
        }

        // Convert current char to digit
        int digit = s.charAt(i) - '0';
        res = res * 10 + digit;

        // Overflow / underflow check
        if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        // Recursive call for next character
        return helper(s, i + 1, res, sign);
    }

    // 🧪 Optional main() for local testing
    public static void main(String[] args) {
        RecursiveAtoi sol = new RecursiveAtoi();
        System.out.println(sol.myAtoi("42"));              // 42
        System.out.println(sol.myAtoi("   -42"));          // -42
        System.out.println(sol.myAtoi("4193 with words")); // 4193
        System.out.println(sol.myAtoi("words 987"));       // 0
        System.out.println(sol.myAtoi("-91283472332"));    // -2147483648
    }
}
