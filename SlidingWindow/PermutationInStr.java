/*
 * Problem: Permutation in String
 * LeetCode #567
 * 
 * Description:
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 * In other words, one of the permutations of s1 is a substring of s2.
 * 
 * Example:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains "ba" which is a permutation of "ab".
 * 
 * -------------------------------------------------------------------
 * Approach: Brute Force (Sorting-Based)
 * -------------------------------------------------------------------
 * 1. Sort the string s1 to get a reference sorted pattern.
 * 2. Generate all possible substrings of s2.
 * 3. For each substring:
 *      - Convert it to a character array and sort it.
 *      - Compare the sorted substring with the sorted s1.
 * 4. If any sorted substring matches, return true.
 * 5. Otherwise, return false.
 * 
 * -------------------------------------------------------------------
 * Time Complexity:
 * O(n^3 *  log n)
 * 
 * 
 * 
 * Space Complexity:
 * O(n)
 * 
 * 
 * -------------------------------------------------------------------
 * Note:
 * This is a brute-force approach and not efficient for large inputs.
 * Optimized solution uses Sliding Window + Frequency Counting.
 */

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Step 1: Sort s1
        char[] Str = s1.toCharArray();
        Arrays.sort(Str);
        String sortedStr = new String(Str);

        // Step 2: Generate all substrings of s2
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {

                // Step 3: Sort current substring
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);

                // Step 4: Compare with sorted s1
                if (sortedSubStr.equals(sortedStr)) {
                    return true;
                }
            }
        }

        // Step 5: No match found
        return false;
    }
}


/*

 * -------------------------------------------------------------------
 * Approach: Sliding Window (Optimized)
 * -------------------------------------------------------------------
 * 1. Create a frequency array for all characters in s1 (size 26).
 * 2. Use two pointers (left, right) to represent a sliding window on s2.
 * 3. Expand the window by moving 'right' — decrement count for the current char.
 *    - If a character was still needed (count > 0), decrement counter.
 * 4. When all required characters are matched (counter == 0):
 *    - Check if window size == s1.length() → return true.
 *    - Else, shrink window from the left.
 * 5. Move 'left' pointer ahead and restore counts for characters that leave.
 * 6. Continue until the end of s2.
 * 
 * -------------------------------------------------------------------
 * Time Complexity: O(n)
 * - Each character in s2 is processed at most twice (entering & leaving window).
 * 
 * Space Complexity: O(1)
 * - Constant space (26 letters).
 * 
 * -------------------------------------------------------------------
 * This is the optimal solution for the problem.
 */

public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Edge case: s2 shorter than s1 -> no permutation possible
        if (s2.length() < s1.length()) return false;

        int left = 0, right = 0;
        int counter = s1.length();  // number of chars still needed to match
        int[] letters = new int[26]; // frequency array for lowercase letters

        // Step 1: Fill frequency map for s1
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
        }

        // Step 2: Slide the window across s2
        while (right < s2.length()) {
            int val = s2.charAt(right) - 'a';

            // If this char is needed, reduce counter
            if (letters[val] > 0) counter--;
            letters[val]--;
            right++;

            // Step 3: When all chars matched, check window size
            while (counter == 0) {
                if (right - left == s1.length()) return true;

                // Shrink window from left
                int startLetter = s2.charAt(left) - 'a';
                letters[startLetter]++;
                if (letters[startLetter] > 0) counter++;
                left++;
            }
        }
        return false;
    }
}
