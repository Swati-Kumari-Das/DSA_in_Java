// 💡 Approach:
// We need to find the smallest and second smallest elements in the array.
// We keep two variables — `small` and `secondsmall`, both initialized to Integer.MAX_VALUE.
//
// Traverse the array once:
// 1️⃣ If current element < small → update secondsmall = small, and small = current element.
// 2️⃣ Else if current element > small but < secondsmall → update secondsmall = current element.
// After traversal, if secondsmall is not updated (still Integer.MAX_VALUE), return [-1].
//
// ✅ This approach works in a single pass (O(n)) and constant extra space (O(1)).

import java.util.*;

class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int small = Integer.MAX_VALUE;
        int secondsmall = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < small) {
                secondsmall = small;
                small = num;
            } else if (num > small && num < secondsmall) {
                secondsmall = num;
            }
        }

        // If no valid second minimum exists (e.g., all elements equal)
        if (secondsmall == Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }

        res.add(small);
        res.add(secondsmall);
        return res;
    }
}

/*
🧠 Example:
Input: [2, 4, 1, 3, 1]
Output: [1, 2]

Input: [5, 5, 5]
Output: [-1]

⏱️ Time Complexity: O(n)
   - We traverse the array only once.

💾 Space Complexity: O(1)
   - We use only constant extra space for variables.
*/

