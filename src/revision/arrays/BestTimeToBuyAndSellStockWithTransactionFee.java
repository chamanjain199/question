package revision.arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {

        int days = prices.length;
        int dp[][] = new int[days + 2][2];

        for (int day = days - 1; day >= 0; day--) {
            dp[day][0] = Math.max(-prices[day] + dp[day + 1][1], dp[day + 1][0]);
            dp[day][1] = Math.max(prices[day]-fee + dp[day + 1][0], dp[day + 1][1]);
        }
        return dp[0][0];

    }

}
