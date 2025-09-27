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

/*
Problem: Reverse Strings (Valid Palindrome)

Approach (Two Pointers):
1. Initialize two pointers: `left` at the start, `right` at the end.
2. Skip non-alphanumeric characters by moving pointers inward.
3. Compare characters at both pointers (case-insensitive).
   - If they differ, return false.
   - If they match, move both pointers inward.
4. Continue until left >= right. If no mismatch found, it's a palindrome.

Time Complexity (TC):
- O(n), where n is the length of the string (each character is visited at most once).

Space Complexity (SC):
- O(1), as no extra data structures are used apart from a few variables.

This approach is more space-efficient than building a new string with StringBuilder.
*/

class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Use two pointers to traverse the string from both ends.
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Step 2: Move the left pointer to the next alphanumeric character.
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Step 3: Move the right pointer to the previous alphanumeric character.
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Step 4: Compare characters (ignoring case).
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            // Step 5: Move both pointers inward.
            left++;
            right--;
        }
        
        // If all characters matched, return true.
        return true;
    }
}
