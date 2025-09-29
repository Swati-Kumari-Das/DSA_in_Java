/*
    Approach:
    - Use the sliding window technique with two pointers (i = left, j = right).
    - Maintain a frequency array `charCount[26]` to track character counts in the window.
    - Track `maxCharCount` = the highest frequency of any character in the current window.
    - At each step:
        * Expand window by moving j (right pointer).
        * If the window becomes invalid, i.e. (window size - maxCharCount > k),
          shrink it by moving i (left pointer).
    - The longest valid window size during traversal is the answer.

    Key Insight:
    - (window size - maxCharCount) tells us how many characters need replacement.
    - If this number is <= k, the window is valid.

    Time Complexity: O(n) → Each character is visited at most twice (expand & shrink).
    Space Complexity: O(26) = O(1) → Constant extra space for frequency count.
*/

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int n = s.length();
        int substring = 0;
        int maxCharCount = 0;
        int[] charCount = new int[26];

        while (j < n) {
            charCount[s.charAt(j) - 'A']++;
            maxCharCount = Math.max(maxCharCount, charCount[s.charAt(j) - 'A']);

            while ((j - i + 1) - maxCharCount > k) {
                charCount[s.charAt(i) - 'A']--;
                i++;
            }

            substring = Math.max(substring, j - i + 1);
            j++;
        }

        return substring;
    }

    // Driver code for testing
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));   // Output: 4
        System.out.println(characterReplacement("AABABBA", 1)); // Output: 4
    }
}
