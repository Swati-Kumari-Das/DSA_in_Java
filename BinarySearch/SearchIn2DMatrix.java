
// Problem: Search a 2D Matrix (LeetCode 74)
// Approach: Brute Force
// Explanation:
// 1. Traverse each element of the matrix row by row.
// 2. If the target is found, return true.
// 3. If traversal completes without finding, return false.
//
// Time Complexity: O(m * n) 
//   - We may check every element in the matrix.
// Space Complexity: O(1) 
//   - No extra space used apart from variables.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Approach: Staircase Search (Start from Top-Right Corner)
//
// Explanation:
// 1. Start from the top-right corner (row = 0, col = n-1).
// 2. If matrix[row][col] > target → move left (col--).
// 3. If matrix[row][col] < target → move down (row++).
// 4. If equal → return true.
// 5. Continue until indices go out of bounds.
// 6. If not found, return false.
//
// Time Complexity: O(m + n)
//   - At most m+n steps since we move either left or down in each step.
// Space Complexity: O(1)
//   - Only constant space used.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;

        while (r < m && c >= 0) {
            if (matrix[r][c] > target) {
                c--; // move left
            } else if (matrix[r][c] < target) {
                r++; // move down
            } else {
                return true; // found
            }
        }
        return false;
    }
}



// Approach: Binary Search on Flattened Matrix
//
// Explanation:
// 1. Treat the 2D matrix as a sorted 1D array of size (m * n).
// 2. Use binary search with indices [0 .. m*n - 1].
//    - Convert a 1D index `mid` to 2D: 
//         row = mid / n, col = mid % n
//    - Compare matrix[row][col] with target.
// 3. If found, return true. Otherwise adjust search space.
// 4. If not found, return false.
//
// Time Complexity: O(log(m * n)) 
//   - Binary search over m*n elements.
// Space Complexity: O(1) 
//   - Only constant extra space used.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int r = mid / n;
            int c = mid % n;
            int val = matrix[r][c];

            if (target == val) {
                return true;
            } else if (target < val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
