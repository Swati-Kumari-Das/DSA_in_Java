// RemoveChars.java
// Problem: Remove all characters from the first string that are present in the second string.

public class RemoveChars {

    // Function to remove characters of str2 from str1
    static String removeChars(String str1, String str2) {
        // Frequency array for lowercase letters (a-z)
        int[] freq = new int[26];
        StringBuilder res = new StringBuilder();

        // Step 1: Mark characters present in str2
        for (char ch : str2.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Build result from str1 excluding chars present in str2
        for (char ch : str1.toCharArray()) {
            if (freq[ch - 'a'] == 0) {
                res.append(ch);
            }
        }

        // Step 3: Return final string after removal
        return res.toString();
    }

    // Driver code for testing
    public static void main(String[] args) {
        String str1 = "computer";
        String str2 = "cat";
        System.out.println("After removing chars of str2 from str1: " + removeChars(str1, str2));
        // Output: ompuer
    }
}

/*
📘 Approach:
1. Use an integer array `freq[26]` to mark characters in `str2`.
2. Traverse `str1` and append characters to result only if they are not present in `str2`.
3. Return the final filtered string.

⏱️ Time Complexity: O(N1 + N2)
    - N1 = length of str1
    - N2 = length of str2

💾 Space Complexity: O(1)
    - Uses a constant-sized array of 26 elements for lowercase letters.
*/
