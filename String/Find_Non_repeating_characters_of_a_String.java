/**
 * Problem: Find the First Non-Repeating Character in a String
 *
 * Given a string s consisting of lowercase alphabets and spaces,
 * return the first non-repeating (unique) character in the string.
 * If there is no such character, return '$'.
 *
 * Example:
 * Input:  s = "geeksforgeeks"
 * Output: 'f'
 *
 * Approach:
 * 1. Create a frequency array of size 26 for all lowercase letters.
 * 2. Traverse the string once and count the frequency of each character (ignore spaces).
 * 3. Traverse the string again to find the first character whose frequency is 1.
 * 4. If no such character exists, return '$'.
 *
 * Time Complexity: O(n)
 *  - We traverse the string twice (once for counting, once for checking).
 *
 * Space Complexity: O(1)
 *  - Frequency array of fixed size (26), independent of input length.
 */

public class Solution {
    public char nonRepeatingChar(String s) {

        int freq[] = new int[26];  // store frequency of each character

        // Step 1: Count frequency of each character
        for (char ch : s.toCharArray()) {
            if (ch != ' ') { 
                freq[ch - 'a']++;
            }
        }

        // Step 2: Find the first character with frequency = 1
        for (char ch : s.toCharArray()) {
            if (ch != ' ' && freq[ch - 'a'] == 1) {
                return ch;
            }
        }

        // Step 3: If no unique character found
        return '$';
    }

    // Optional: You can include a main() to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "geeksforgeeks";
        System.out.println("First non-repeating character: " + sol.nonRepeatingChar(s));
    }
}
