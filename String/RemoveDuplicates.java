/**
 * Problem: Remove Duplicates from String
 *
 * Given a string s, the task is to remove all duplicate characters
 * from it while keeping only the first occurrence of each character
 * and maintaining the original order of appearance.
 *
 * Examples:
 * Input:  s = "zvvo"
 * Output: "zvo"
 *
 * Input:  s = "geeksforgeeks"
 * Output: "geksfor"
 *
 * Approach:
 * - Use a HashSet to keep track of characters that have already appeared.
 * - Use a StringBuilder to build the result string.
 * - Traverse each character of the string:
 *      → If it has not been seen before, append it to the result and mark it as seen.
 *      → If already seen, skip it.
 *
 * Time Complexity: O(n)
 *   - We iterate through the string once and HashSet operations take O(1) average time.
 *
 * Space Complexity: O(k)
 *   - Where k is the number of distinct characters in the string (at most 26 for lowercase English letters).
 */

import java.util.HashSet;

class Solution {

    /**
     * Removes duplicate characters from the given string
     * while preserving the original order.
     *
     * @param s Input string
     * @return String with duplicates removed
     */
    String removeDuplicates(String s) {
        HashSet<Character> exists = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!exists.contains(c)) {
                ans.append(c);
                exists.add(c);
            }
        }

        return ans.toString();
    }

    // Driver code for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.removeDuplicates("zvvo"));          // Output: "zvo"
        System.out.println(sol.removeDuplicates("geeksforgeeks")); // Output: "geksfor"
        System.out.println(sol.removeDuplicates("aabbccdd"));      // Output: "abcd"
    }
}


/**
 * Problem: Remove Duplicates from String
 *
 * Given a string s, remove all duplicate characters while preserving the
 * original order of characters and keeping only the first occurrence of each.
 *
 * Examples:
 * Input:  "geeksforgeeks"
 * Output: "geksfor"
 *
 * Input:  "zvvo"
 * Output: "zvo"
 *
 * Approach:
 * - Use an integer array of size 256 to track ASCII character occurrences.
 * - Iterate over the string:
 *      → If character has not appeared yet (frequency 0), append it to the result and mark as seen.
 *      → Otherwise, skip it.
 * - Convert the StringBuilder to a String and return.
 *
 * Time Complexity: O(n) -> iterate through the string once
 * Space Complexity: O(256) -> constant space for ASCII characters
 */

class Solution {

    /**
     * Removes duplicate characters from a string.
     *
     * @param s Input string
     * @return String with duplicates removed
     */
    String removeDuplicates(String s) {
        int[] ch = new int[256]; // ASCII frequency array
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (ch[c] == 0) {
                ans.append(c);
                ch[c]++;
            }
        }

        return ans.toString();
    }

    // Driver code for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.removeDuplicates("geeksforgeeks")); // Output: "geksfor"
        System.out.println(sol.removeDuplicates("zvvo"));          // Output: "zvo"
        System.out.println(sol.removeDuplicates("aabbcc"));        // Output: "abc"
        System.out.println(sol.removeDuplicates("xyzxyzxyz"));     // Output: "xyz"
    }
}
