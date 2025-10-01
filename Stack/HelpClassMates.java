// Problem: Next Smaller Element to the Right
// Approach: Monotonic Stack
import java.util.*;
class Solution {
    public static int[] help_classmate(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];

        // Traverse array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements greater than or equal to arr[i]
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            // If stack is empty → no smaller element exists
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek(); // Top of stack is next smaller element
            }
            // Push current element to stack
            st.push(arr[i]);
        }
        return res;
    }
}

/*
---------------------------------------------------------
Approach Explanation
---------------------------------------------------------
- Use a stack to keep track of next smaller elements.
- Traverse from right to left:
  1. Pop all elements from stack that are >= arr[i].
  2. If stack is empty → no smaller element exists, mark -1.
  3. Else → top of stack is next smaller element, store it in res[i].
  4. Push current element to stack.
  
Example:
arr = [4, 5, 2, 10, 8]
Result = [2, 2, -1, 8, -1]

---------------------------------------------------------
Time Complexity: O(n) → each element is pushed/popped once
Space Complexity: O(n) → stack and result array
---------------------------------------------------------
*/
