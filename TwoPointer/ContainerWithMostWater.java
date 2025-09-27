
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

// Approach: Two Pointers (Optimized)

/*
Approach:
1. Place two pointers: one at the start (i = 0), one at the end (j = n-1).
2. Compute the area formed by heights[i] and heights[j]:
      height = min(heights[i], heights[j])
      width  = j - i
      area   = height * width
3. Update the maximum area (res).
4. Move the pointer pointing to the smaller height inward:
      - If heights[i] <= heights[j], then i++
      - Else j--
   (This works because the limiting factor is the smaller height.)
5. Repeat until i < j.

Time Complexity:
- O(n), since each element is visited at most once by either pointer.

Space Complexity:
- O(1), as only a few extra variables are used.
*/

class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        int res = 0;

        while (i < j) {
            int water = Math.min(heights[i], heights[j]) * (j - i);
            res = Math.max(res, water);

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}

