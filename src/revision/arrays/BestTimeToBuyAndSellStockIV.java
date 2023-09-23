package revision.arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfitTopDown(int k, int[] prices) {
        int days = prices.length;
        int[][][] dp = new int[days + 1][2][k+1];
        for (int day = days - 1; day >= 0; day--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                for (int cap = k - 1; cap >= 0; cap--) {
                    if (canBuy == 0) {
                        dp[day][0][cap] = Math.max(-prices[day] + dp[day + 1][1][cap], dp[day + 1][0][cap]);
                    } else {
                        dp[day][1][cap] = Math.max(prices[day] + dp[day + 1][0][cap + 1], dp[day + 1][1][cap]);
                    }
                }

            }
        }
        return dp[0][0][0];
    }

}
