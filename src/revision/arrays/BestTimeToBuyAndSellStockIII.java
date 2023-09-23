package revision.arrays;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    int dp[][][];

    public int maxProfit(int[] prices) {
        int days = prices.length;
        dp = new int[days][2][3];
        for (int[][] aa : dp) {
            for (int[] a : aa) {
                Arrays.fill(a, -1);
            }
        }
        return maxProfitTopdown(0, 0, 2, prices);
    }

    private int maxProfitTopdown(int day, int canBuy, int noTx, int[] prices) {

        if (noTx == 0 || day == prices.length) {
            return 0;
        }
        if (dp[day][canBuy][noTx] != -1) {
            return dp[day][canBuy][noTx];
        }
        if (canBuy == 0) {
            return dp[day][canBuy][noTx] = Math.max(-prices[day] + maxProfitTopdown(day + 1, 1, noTx, prices), maxProfitTopdown(day + 1, 0, noTx, prices));
        } else {
            return dp[day][canBuy][noTx] = Math.max(prices[day] + maxProfitTopdown(day + 1, 0, noTx - 1, prices), maxProfitTopdown(day + 1, 1, noTx, prices));
        }
    }

    public int maxProfitTopDown(int[] prices) {
        int days = prices.length;
        dp = new int[days + 1][2][3];
        for (int day = days - 1; day >= 0; day--) {
            for (int canBuy = 1; canBuy >= 0; canBuy--) {
                for (int cap = 1; cap >= 0; cap--) {
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
