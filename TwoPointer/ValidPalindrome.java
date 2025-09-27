/*
Problem: Reverse Strings (Valid Palindrome)

Approach:
1. Iterate through the string and build a cleaned version containing only 
   alphanumeric characters, converting them to lowercase.
2. Use StringBuilder to construct this new string.
3. Compare the string with its reversed version to check for palindrome.

Time Complexity (TC): 
- O(n), where n is the length of the string (traversal + reversal comparison).

Space Complexity (SC): 
- O(n), for storing the cleaned string in StringBuilder.

*/

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();

        // Step 1: Clean the string
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }

        // Step 2: Check palindrome by comparing with reverse
        return newStr.toString().equals(newStr.reverse().toString());
    }
}
