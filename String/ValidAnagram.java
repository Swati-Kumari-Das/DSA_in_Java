/**
 * Problem: Check if Two Strings are Anagrams
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example:
 * Input:  s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input:  s = "rat", t = "car"
 * Output: false
 *
 * Approach:
 * 1. If the lengths of both strings differ, they cannot be anagrams → return false.
 * 2. Create an integer frequency array of size 26 for all lowercase letters.
 * 3. Increment frequency for each character in `s`.
 * 4. Decrement frequency for each character in `t`.
 * 5. If all frequencies are zero at the end, the two strings are anagrams.
 *
 * Time Complexity: O(n)
 *  - We traverse both strings once (n = length of the strings)
 *
 * Space Complexity: O(1)
 *  - Fixed-size frequency array (26), independent of input size.
 */

public class Solution {
    static final int MAX = 26;

    public boolean isAnagram(String s, String t) {
        // Step 1: Check if lengths are different
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for all lowercase letters
        int[] freq = new int[MAX];

        // Step 3: Increment for s, decrement for t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // Step 4: Verify if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(sol.isAnagram(s, t)); // true
    }
}
