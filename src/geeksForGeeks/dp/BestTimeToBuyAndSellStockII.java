package geeksForGeeks.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    int dp[][];

    public int maxProfit(int[] prices) {
        int len = prices.length;
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
            return dp[day][canBuy] = Math.max(prices[day] + maxProfit(prices, day + 1, 0), maxProfit(prices, day + 1, 1));
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
                    dp[day][canBuy] = Math.max(prices[day] + dp[day + 1][0], dp[day + 1][1]);
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
            dp[day][1] = Math.max(prices[day] + dp[day + 1][0], dp[day + 1][1]);
        }

        return dp[0][0];
    }
    public int maxProfitOptimized(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII obj=new BestTimeToBuyAndSellStockII();
        System.out.println(obj.maxProfit(new int[]{7,8,100}));
    }
}
