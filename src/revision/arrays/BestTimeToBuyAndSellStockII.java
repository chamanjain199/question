package revision.arrays;

public class BestTimeToBuyAndSellStockII {
    public int stockBuySell(int[] price, int n) {
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (price[i] > price[i - 1]) {
                maxProfit += price[i] - price[i - 1];
            }
        }
        return maxProfit;
    }

    public int maxProfitTopDown(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int day = n - 1; day >= 0; day--) {
            dp[day][0] = Math.max(-prices[day] + dp[day + 1][1], dp[day + 1][0]);
            dp[day][1] = Math.max(prices[day] + dp[day + 1][0], dp[day + 1][1]);
        }
        return dp[0][0];
    }
    public static void main(String[] args) {

    }
}
