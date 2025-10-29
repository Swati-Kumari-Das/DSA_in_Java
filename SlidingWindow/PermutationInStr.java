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
