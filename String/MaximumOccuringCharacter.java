/**
 * Problem: Most Frequent Character
 *
 * Given a string s of lowercase alphabets, find the maximum occurring character.
 * If more than one character occurs the maximum number of times, return the 
 * lexicographically smaller character.
 *
 * Examples:
 * Input: "testsample"
 * Output: 'e'
 * Explanation: 'e' occurs the most number of times.
 *
 * Input: "output"
 * Output: 't'
 * Explanation: 't' and 'u' both occur 2 times, but 't' is lexicographically smaller.
 *
 * Approach:
 * - Use an integer array of size 26 to count the frequency of each lowercase character.
 * - Iterate over the array from index 0 ('a') to 25 ('z') to find the character with maximum frequency.
 * - Iterating from 'a' to 'z' ensures that if there is a tie, the lexicographically smaller character is returned.
 *
 * Time Complexity: O(n) -> Traverse the string once and then the frequency array of size 26.
 * Space Complexity: O(26) -> Constant space for the frequency array.
 */

class Solution {

    /**
     * Returns the maximum occurring character in the string.
     *
     * @param s input string of lowercase alphabets
     * @return character that occurs maximum times (lexicographically smallest if tie)
     */
    public char getMaxOccuringChar(String s) {
        int[] freq = new int[26]; // For 'a' to 'z'

        // Count frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxFreq = 0;
        char maxChar = 'a'; // Initialize with smallest lexicographical char

        // Iterate from 'a' to 'z' to handle tie by lexicographical order
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = (char) (i + 'a');
            }
        }

        return maxChar;
    }

    // Driver code for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Cases
        System.out.println(sol.getMaxOccuringChar("testsample")); // Output: 'e'
        System.out.println(sol.getMaxOccuringChar("output"));     // Output: 't'
        System.out.println(sol.getMaxOccuringChar("aabbcc"));     // Output: 'a'
        System.out.println(sol.getMaxOccuringChar("xyzxyzxyz"));  // Output: 'x'
    }
}
