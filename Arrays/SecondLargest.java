// 💡 Approach:
// The task is to find the second largest element in the array.
// We maintain two variables — `largest` and `secondLargest`.
//
// 🔹 Traverse the array once:
//     - If the current element > largest → update secondLargest = largest, and largest = current element.
//     - Else if current element < largest but > secondLargest → update secondLargest = current element.
// 🔹 After the loop, return `secondLargest`.
// If no second largest exists (e.g., all elements are same), it will remain -1.
//
// ✅ Single pass (O(n)) approach with constant extra space (O(1)).

import java.util.*;

class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}

/*
🧠 Example:
Input: [12, 35, 1, 10, 34, 1]
Output: 34

Input: [10, 10, 10]
Output: -1  (No second largest)

⏱️ Time Complexity: O(n)
   - Single traversal through the array.

💾 Space Complexity: O(1)
   - Only constant extra variables used.
*/


