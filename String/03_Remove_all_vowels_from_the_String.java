/*
Remove Vowels from a String
---------------------------
Given a string, remove all lowercase vowels (a, e, i, o, u) and return the new string.

Approach:
---------
- Use StringBuilder to efficiently build the new string.
- Loop through each character
- If character is not a vowel, append it to StringBuilder
- Return final result

Time Complexity: O(n)  → We iterate once through the string
Space Complexity: O(n) → StringBuilder stores output
*/

class Solution {
    String removeVowels(String s) {
        
        StringBuilder newStr = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                continue; // skip vowels
            }
            newStr.append(ch); // append consonants
        }

        return newStr.toString();
    }
}
