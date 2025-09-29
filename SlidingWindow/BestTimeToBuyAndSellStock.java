/*
    Approach:
    - Use brute force by checking every possible pair of buy and sell days.
    - For each pair (i, j) where i < j:
        * prices[i] = buy price
        * prices[j] = sell price
        * Calculate profit = sell - buy
        * Update the maximum profit if profit is greater.
    - If no profitable transaction exists, result remains 0.

    Time Complexity: O(n^2) → Two nested loops over the array
    Space Complexity: O(1) → Only constant extra variables used
*/

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }

        return res;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] prices1 = {10, 1, 5, 6, 7, 1};
        int[] prices2 = {10, 8, 7, 5, 2};

        System.out.println("Max Profit (Example 1): " + maxProfit(prices1)); // Output: 6
        System.out.println("Max Profit (Example 2): " + maxProfit(prices2)); // Output: 0
    }
}
