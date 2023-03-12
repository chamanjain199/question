package geeksForGeeks.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    int dp[][];

    int fee;

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        this.fee = fee;
        dp = new int[len][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return maxProfit(prices, 0, 0);
    }

    private int maxProfit(int[] prices, int day, int canBuy) {
        if (day == prices.length) {
            return 0;
        }
        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }
        if (canBuy == 0) {
            return dp[day][canBuy] = Math.max(-prices[day] + maxProfit(prices, day + 1, 1), maxProfit(prices, day + 1, 0));
        } else {
            return dp[day][canBuy] = Math.max(prices[day] - fee + maxProfit(prices, day + 1, 0), maxProfit(prices, day + 1, 1));
        }
    }

    public int maxProfitBottomUp(int[] prices) {
        int len = prices.length;
        dp = new int[len + 1][2];
        for (int day = len - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 0) {
                    dp[day][canBuy] = Math.max(-prices[day] + dp[day + 1][1], dp[day + 1][0]);
                } else {
                    dp[day][canBuy] = Math.max(prices[day] - fee + dp[day + 1][0], dp[day + 1][1]);
                }
            }
        }

        return dp[0][0];
    }


    public int maxProfitBottomUpSpaceOptimized(int[] prices) {
        int len = prices.length;
        dp = new int[len + 1][2];
        for (int day = len - 1; day >= 0; day--) {
            dp[day][0] = Math.max(-prices[day] + dp[day + 1][1], dp[day + 1][0]);
            dp[day][1] = Math.max(prices[day] - fee + dp[day + 1][0], dp[day + 1][1]);
        }

        return dp[0][0];
    }
}
