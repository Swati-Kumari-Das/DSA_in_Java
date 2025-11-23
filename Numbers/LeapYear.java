/**
 * LeapYearSolution.java
 *
 * This file contains the Solution class with the isLeap method
 * written exactly as required. It also includes:
 *  - Approach explanation
 *  - Time Complexity (TC)
 *  - Space Complexity (SC)
 *
 * Suitable for uploading directly to GitHub.
 */

public class Solution {

    /**
     * APPROACH:
     * A year is considered a leap year based on these rules:
     *   1. If divisible by 400 → Leap Year
     *   2. Else if divisible by 100 → Not a Leap Year
     *   3. Else if divisible by 4 → Leap Year
     *   4. Otherwise → Not a Leap Year
     *
     * We apply these conditions in order because:
     *   - Years divisible by 400 override all other rules.
     *   - Years divisible by 100 are exceptions unless divisible by 400.
     *   - Years divisible by 4 are normally leap years.
     *
     * TIME COMPLEXITY:
     *   O(1) → Only simple arithmetic comparisons.
     *
     * SPACE COMPLEXITY:
     *   O(1) → No extra memory used.
     */
    static boolean isLeap(int N) {
        // If divisible by 400 → leap year
        if (N % 400 == 0) return true;

        // If divisible by 100 but not 400 → not leap year
        if (N % 100 == 0) return false;

        // If divisible by 4 → leap year
        if (N % 4 == 0) return true;

        // Otherwise → not a leap year
        return false;
    }

    // Optional main() for testing
    public static void main(String[] args) {
        int[] years = {1600, 1700, 1800, 1900, 2000, 2004, 2019, 2020, 2100};
        for (int year : years) {
            System.out.println(year + " -> " + isLeap(year));
        }
    }
}
