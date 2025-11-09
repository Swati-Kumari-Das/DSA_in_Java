/**
 * Problem: Common Subsequence (Easy)
 * 
 * Given two strings S1 and S2, determine if they contain any common 
 * subsequence (non-empty). A common subsequence of length >=1 exists 
 * if and only if there is at least one common character.
 *
 * Example 1:
 * Input: S1 = "ABEF", S2 = "CADE"
 * Output: 1
 * Explanation: "A", "E", "AE" are in both S1 and S2.
 * 
 * Example 2:
 * Input: S1 = "ABCDE", S2 = "FGHIJ"
 * Output: 0
 * Explanation: There is no common subsequence.
 *
 * Approach:
 * - Any single character that appears in both strings is a common subsequence.
 * - Use a boolean array of size 26 (for uppercase letters) to mark characters in S1.
 * - Iterate over S2; if any character is present in S1, return 1.
 * - Otherwise, return 0.
 *
 * Time Complexity: O(|S1| + |S2|)  -> Linear scan of both strings
 * Space Complexity: O(26) -> Constant space for uppercase letters
 */

class Solution {

    /**
     * Function to check if S1 and S2 have any common subsequence
     * @param S1 First string
     * @param S2 Second string
     * @return 1 if common subsequence exists, else 0
     */
    static int commonSubseq(String S1, String S2) {
        boolean[] seen = new boolean[26]; // For uppercase letters A-Z

        // Mark characters present in S1
        for (char ch : S1.toCharArray()) {
            seen[ch - 'A'] = true;
        }

        // Check if any character in S2 is also in S1
        for (char ch : S2.toCharArray()) {
            if (seen[ch - 'A']) {
                return 1; // Found common subsequence of length 1
            }
        }

        return 0; // No common character found
    }

    // Driver program to test the function
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ABEF";
        String s2 = "CADE";
        System.out.println("Test Case 1 Output: " + commonSubseq(s1, s2)); // Expected: 1

        // Test Case 2
        s1 = "ABCDE";
        s2 = "FGHIJ";
        System.out.println("Test Case 2 Output: " + commonSubseq(s1, s2)); // Expected: 0

        // Test Case 3: common character at end
        s1 = "XYZ";
        s2 = "ZPQ";
        System.out.println("Test Case 3 Output: " + commonSubseq(s1, s2)); // Expected: 1

        // Test Case 4: identical strings
        s1 = "HELLO";
        s2 = "HELLO";
        System.out.println("Test Case 4 Output: " + commonSubseq(s1, s2)); // Expected: 1

        // Test Case 5: no characters in common
        s1 = "ABC";
        s2 = "DEF";
        System.out.println("Test Case 5 Output: " + commonSubseq(s1, s2)); // Expected: 0
    }
}
