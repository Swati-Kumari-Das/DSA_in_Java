
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
