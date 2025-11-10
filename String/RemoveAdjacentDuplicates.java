// LeetCode 1047: Remove All Adjacent Duplicates in String
// Difficulty: Easy

/*
Approach:
---------
We use a StringBuilder as a stack.

1️⃣ Iterate through each character of the string.
2️⃣ For every character:
    - If the stack is not empty AND the current character is equal to the top element of the stack,
      remove the top character (since both are adjacent duplicates).
    - Otherwise, push (append) the current character into the stack.
3️⃣ After processing all characters, the stack will contain the final result string
    without any adjacent duplicates.

Why it works:
--------------
Each time two adjacent duplicates appear, they "cancel" each other out.
The StringBuilder acts like a stack that always keeps only non-duplicate characters.

Example:
---------
Input: s = "abbaca"
Steps:
a -> stack: [a]
b -> stack: [a, b]
b -> duplicate of top, remove -> stack: [a]
a -> duplicate of top, remove -> stack: []
c -> stack: [c]
a -> stack: [c, a]
Output: "ca"

Time Complexity:  O(n)
- Each character is visited once and possibly removed once.
- Therefore, total operations are proportional to n (length of the string).

Space Complexity: O(n)
- The StringBuilder acts like a stack, and in the worst case (no duplicates), 
  it stores all characters.

*/

public class RemoveDuplicates {
    public static String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();
            // If current character equals top of stack -> remove it
            if (len > 0 && stack.charAt(len - 1) == ch) {
                stack.deleteCharAt(len - 1);
            } else {
                // Else push character to stack
                stack.append(ch);
            }
        }

        // Return final string after removing duplicates
        return stack.toString();
    }

    // Example usage
    public static void main(String[] args) {
        String s1 = "abbaca";
        String s2 = "azxxzy";

        System.out.println("Input: " + s1 + " → Output: " + removeDuplicates(s1));
        System.out.println("Input: " + s2 + " → Output: " + removeDuplicates(s2));
    }
}
