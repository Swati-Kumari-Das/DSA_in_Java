/**
 * Problem: Capitalize First and Last Character of Each Word
 *
 * Given a string, capitalize the first and last character of every word.
 *
 * Approach:
 * 1. Convert the string to a character array.
 * 2. Traverse through the string:
 *      - Skip spaces
 *      - Mark start index of a word
 *      - Move to the end of the word
 * 3. Capitalize:
 *      - First character of word (if lowercase)
 *      - Last character of word (if lowercase and word length > 1)
 * 4. Return the modified char array as string.
 *
 * Time Complexity: O(n)
 *  - Each character is processed once
 *
 * Space Complexity: O(n)
 *  - Character array to store output
 */

class Solution {
    // Function to capitalize first and last character of each word
    public String capitalizeFirstLast(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int start = 0;

        // Traverse the string word by word
        while (start < n) {
            // Skip spaces
            while (start < n && arr[start] == ' ')
                start++;

            if (start >= n)
                break;

            int end = start;

            // Find the end of the current word
            while (end < n && arr[end] != ' ')
                end++;

            // Capitalize first character if lowercase
            if (Character.isLowerCase(arr[start]))
                arr[start] = Character.toUpperCase(arr[start]);

            // Capitalize last character if lowercase and word length > 1
            if (end - 1 > start && Character.isLowerCase(arr[end - 1]))
                arr[end - 1] = Character.toUpperCase(arr[end - 1]);

            // Move to next word
            start = end;
        }

        // Return modified string
        return new String(arr);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "hello world from chatgpt";

        System.out.println(sol.capitalizeFirstLast(s));
    }
}
