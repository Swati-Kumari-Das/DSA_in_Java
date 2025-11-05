/*
Problem: Find the sum of all numbers present in a string.
Example:
Input: "a12b3c45"
Output: 60  (12 + 3 + 45 = 60)

Approach:
- Traverse the string character by character.
- If character is a digit, append to temp string to build the number.
- If non-digit, convert temp string to number and add to total sum.
- Reset temp string and continue.
- Finally, add the last collected number.

Time Complexity: O(n) — scanning string once.
Space Complexity: O(1) — only few variables used.
*/

class Solution {
    public int findSum(String s) {

        String tempSum = "0"; 
        int sum = 0;

        for(char ch : s.toCharArray()) {

            if(Character.isDigit(ch)) {
                tempSum += ch; // build multi-digit number
            } 
            else {
                sum += Integer.parseInt(tempSum);
                tempSum = "0"; // reset for next number
            }
        }

        // Add last collected number
        return sum + Integer.parseInt(tempSum);
    }

    // driver code example (optional for testing locally)
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findSum("a12b3c45")); // Output: 60
    }
}
