
// Problem: Container With Most Water (LeetCode #11)
// Approach: Brute Force (Check all pairs)

/*
Approach:
1. Iterate through every possible pair of lines (i, j).
2. The area formed is determined by:
      height = min(heights[i], heights[j])
      width = j - i
      area = height * width
3. Keep track of the maximum area encountered.

Time Complexity:
- O(n^2) because we check all pairs (i, j).
- This is inefficient for large arrays.

Space Complexity:
- O(1), since no extra space is used (besides a few variables).
*/

import java.util.*;

class Solution {
    public int maxArea(int[] heights) {
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = height * width;

                res = Math.max(res, area);
            }
        }

        return res;
    }
}
