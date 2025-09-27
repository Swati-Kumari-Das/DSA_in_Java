
// Problem: Largest Triangle Area (LeetCode #812)
// Approach: Brute Force (Check all possible triplets of points)

/*
Approach:
1. A triangle is defined by 3 points.
2. Iterate over all possible triplets of points using 3 nested loops.
3. For each triplet (p1, p2, p3), compute the area using the shoelace formula:
      Area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|
4. Track the maximum area found.

Time Complexity:
- O(n^3), since we check every triplet of points.
- n = number of points.

Space Complexity:
- O(1), only a few variables used.
*/

class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        // Try all triplets of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Extract coordinates
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int x3 = points[k][0], y3 = points[k][1];

                    // Shoelace formula
                    double area = 0.5 * Math.abs(
                        x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)
                    );

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
