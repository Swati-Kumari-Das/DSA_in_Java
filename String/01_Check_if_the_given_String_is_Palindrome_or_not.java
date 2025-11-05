// Approach:
// Use two-pointer technique to check if a string is palindrome
// TC: O(n) — we traverse the string once
// SC: O(1) — constant extra space

public class Solution {
    
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // main method to test the function
    public static void main(String[] args) {
        Solution obj = new Solution();
        String str = "madam";

        if (obj.isPalindrome(str)) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is NOT a Palindrome");
        }
    }
}
