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

/*
    Approach:
    - Use two pointers (sliding window).
    - Pointer i = buy day, pointer j = sell day.
    - Traverse the array while j < n:
        * If prices[j] > prices[i], calculate profit = prices[j] - prices[i]
          and update maxProfit if it's larger.
        * Else, move i = j (shift the buy pointer to a cheaper price).
    - Continue until the end and return maxProfit.

    Time Complexity: O(n) → Single pass through the array
    Space Complexity: O(1) → Only constant extra variables used
*/

public class BestTimeToBuyAndSellStockOptimized {

    public static int maxProfit(int[] prices) {
        int i = 0;  // Buy pointer
        int j = 1;  // Sell pointer
        int maxProfit = 0;

        while (j < prices.length) {
            if (prices[i] < prices[j]) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                i = j; // update buy day to cheaper price
            }
            j++;
        }
        return maxProfit;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] prices1 = {10, 1, 5, 6, 7, 1};
        int[] prices2 = {10, 8, 7, 5, 2};

        System.out.println("Max Profit (Example 1): " + maxProfit(prices1)); // Output: 6
        System.out.println("Max Profit (Example 2): " + maxProfit(prices2)); // Output: 0
    }
}

/*
    Approach:
    - Keep track of the minimum price observed so far while traversing the array.
    - For each price:
        * If it's lower than the current minPrice, update minPrice.
        * Otherwise, calculate profit = price - minPrice
          and update maxProfit if this profit is larger.
    - By the end, maxProfit will hold the maximum possible profit.

    Time Complexity: O(n) → Single pass through the array
    Space Complexity: O(1) → Only constant variables used
*/

public class BestTimeToBuyAndSellStockDP {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] prices1 = {10, 1, 5, 6, 7, 1};
        int[] prices2 = {10, 8, 7, 5, 2};

        System.out.println("Max Profit (Example 1): " + maxProfit(prices1)); // Output: 6
        System.out.println("Max Profit (Example 2): " + maxProfit(prices2)); // Output: 0
    }
}


