
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 54: Spiral Matrix
 *
 * Problem:
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Approach:
 * - Use four pointers to track the current boundaries:
 *   SR = start row, ER = end row
 *   SC = start column, EC = end column
 * - Traverse in four directions:
 *   1. Left → Right (top row), then increment SR
 *   2. Top → Bottom (right column), then decrement EC
 *   3. Right → Left (bottom row, if valid), then decrement ER
 *   4. Bottom → Top (left column, if valid), then increment SC
 * - Continue until boundaries cross.
 *
 * Time Complexity: O(m * n)
 *   Each element is visited exactly once.
 *
 * Space Complexity:
 *   Auxiliary: O(1) (only pointers used)
 *   Total: O(m * n) due to result storage
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;  // edge case

        int SR = 0, SC = 0;
        int ER = matrix.length - 1;
        int EC = matrix[0].length - 1;

        while (SR <= ER && SC <= EC) {
            // 1. Left → Right
            for (int c = SC; c <= EC; c++) {
                res.add(matrix[SR][c]);
            }
            SR++;

            // 2. Top → Bottom
            for (int r = SR; r <= ER; r++) {
                res.add(matrix[r][EC]);
            }
            EC--;

            // 3. Right → Left (if still valid row)
            if (SR <= ER) {
                for (int c = EC; c >= SC; c--) {
                    res.add(matrix[ER][c]);
                }
                ER--;
            }

            // 4. Bottom → Top (if still valid column)
            if (SC <= EC) {
                for (int r = ER; r >= SR; r--) {
                    res.add(matrix[r][SC]);
                }
                SC++;
            }
        }

        return res;
    }

    // For quick local testing
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(sm.spiralOrder(matrix));
    }
}
