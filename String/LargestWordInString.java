// LongestWordFinder.java
// Program to find the longest word in a given input string.

import java.util.Scanner;

public class LongestWordFinder {
    public static void main(String[] args) {

        // Step 1: Read the string from the user
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Step 2: Split the string into words using whitespace as delimiter
            String[] words = input.split("\\s+");

            // Step 3: Identify the longest word
            String longestWord = "";
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            // Step 4: Display the longest word
            System.out.println("Longest word: " + longestWord);
        }
    }
}

/*
📘 Approach:
1. Read the input string from the user.
2. Split the string into words using regex "\\s+" (which handles multiple spaces).
3. Iterate through all words and track the one with the maximum length.
4. Print the longest word.

🧠 Example:
Input:  "Java is a powerful language"
Output: "powerful"

⏱️ Time Complexity: O(N)
   - N = total number of characters in the string.
💾 Space Complexity: O(W)
   - W = number of words (due to splitting into an array).
*/
