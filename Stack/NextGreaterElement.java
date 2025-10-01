// Problem: Next Greater Element (LeetCode / GeeksforGeeks variation)
// Approach: Monotonic Stack
import java.util.*;
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements smaller or equal to arr[i]
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty → no greater element
            if (st.isEmpty()) {
                res.add(-1);
            } else {
                res.add(st.peek());
            }

            // Push current element to stack
            st.push(arr[i]);
        }

        // Reverse result as we traversed from right
        Collections.reverse(res);

        return res;
    }
}

/*
---------------------------------------------------------
Approach Explanation
---------------------------------------------------------
- Use a stack to keep track of next greater elements.
- Traverse from right to left:
  1. Pop elements from stack that are ≤ current element.
  2. If stack becomes empty → no greater element exists, add -1.
  3. Else → top of stack is next greater element, add it to result.
  4. Push current element to stack.
- Reverse the result list at the end.

Example:
arr = [4, 5, 2, 25]
Result = [5, 25, 25, -1]

---------------------------------------------------------
Time Complexity: O(n) → Each element pushed/popped once
Space Complexity: O(n) → Stack and result list
---------------------------------------------------------
*/
