package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.Map;

public class BestTimeToBuyAndSellStockIII {
    int dp[][][];
    int dp2[][];


    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        dp = new int[len][2][k + 1];
        for (int[][] arr : dp) {
            for (int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        return maxProfitTopDown(prices, 0, 0, k);
    }

    public int maxProfitTopDown(int[] prices, int day, int canBuy, int noTx) {
        if (noTx == 0 || day == prices.length) {
            return 0;
        }
        if (dp[day][canBuy][noTx] != -1) {
            return dp[day][canBuy][noTx];
        }
        if (canBuy == 0) {
            return dp[day][canBuy][noTx] = Math.max(-prices[day] + maxProfitTopDown(prices, day + 1, 1, noTx)
                    , maxProfitTopDown(prices, day + 1, 0, noTx));
        }
        return dp[day][canBuy][noTx] = Math.max(prices[day] + maxProfitTopDown(prices, day + 1, 0, noTx - 1)
                , maxProfitTopDown(prices, day + 1, 1, noTx));
    }

    public int maxProfit2(int k, int[] prices) {
        int len = prices.length;
        dp2 = new int[len][2 * k + 1];
        for (int[] arr2 : dp2) {
            Arrays.fill(arr2, -1);
        }
        return maxProfitTopDown2(prices, 0, 0, k);
    }

    public int maxProfitTopDown2(int[] prices, int day, int txNo, int k) {
        if (txNo == 2 * k || day == prices.length) {
            return 0;
        }
        if (dp2[day][txNo] != -1) {
            return dp2[day][txNo];
        }
        if ((txNo & 1) == 0) {
            return dp2[day][txNo] = Math.max(-prices[day] + maxProfitTopDown2(prices, day + 1, txNo + 1, k)
                    , maxProfitTopDown2(prices, day + 1, txNo, k));
        }
        return dp2[day][txNo] = Math.max(prices[day] + maxProfitTopDown2(prices, day + 1, txNo + 1, k)
                , maxProfitTopDown2(prices, day + 1, txNo, k));
    }

    public int maxProfitBottomUp(int k, int[] prices) {
        int len = prices.length;
        dp = new int[len + 1][2][k + 1];
        for (int ind = len - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) {// We can buy the stock
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }
                    if (buy == 1) {// We can sell the stock
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }

    public int maxProfitBottomUpSpaceOptimized(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][k + 1];
        int[][] cur = new int[2][k + 1];
        for (int ind = len - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {

                    if (buy == 0) {// We can buy the stock
                        cur[buy][cap] = Math.max(dp[0][cap],
                                -prices[ind] + dp[1][cap]);
                    }
                    if (buy == 1) {// We can sell the stock
                        cur[buy][cap] = Math.max(dp[1][cap],
                                prices[ind] + dp[0][cap - 1]);
                    }
                }
            }
            dp = cur;
        }
        return dp[0][k];
    }

    public int maxProfitBottomUp2(int k, int[] prices) {
        int len = prices.length;
        dp2 = new int[len + 1][2 * k + 1];
        for (int ind = len - 1; ind >= 0; ind--) {
            for (int txNo = 2 * k - 1; txNo >= 0; txNo--) {
                if ((txNo & 1) == 0) {
                    dp2[ind][txNo] = Math.max(dp2[ind + 1][txNo],
                            -prices[ind] + dp2[ind + 1][txNo + 1]);
                } else {
                    dp2[ind][txNo] = Math.max(dp2[ind + 1][txNo],
                            prices[ind] + dp2[ind + 1][txNo + 1]);
                }
            }
        }
        return dp2[0][0];
    }

    public int maxProfitBottomUp2SpaceOptimized(int k, int[] prices) {
        int len = prices.length;
        int[] dp2 = new int[2 * k + 1];
        int[] cur;
        for (int ind = len - 1; ind >= 0; ind--) {
            cur = new int[2 * k + 1];
            for (int txNo = 2 * k - 1; txNo >= 0; txNo--) {
                if ((txNo & 1) == 0) {
                    cur[txNo] = Math.max(dp2[txNo],
                            -prices[ind] + dp2[txNo + 1]);
                } else {
                    cur[txNo] = Math.max(dp2[txNo],
                            prices[ind] + dp2[txNo + 1]);
                }
            }
            dp2 = cur;
        }
        return dp2[0];
    }


    public int maxProfitOptimized(int[] prices) {

        int n = prices.length;

        int first_stock = Integer.MAX_VALUE, second_stock = Integer.MAX_VALUE;

        int first_profit = 0, final_profit = 0;

        for (int price : prices) {

            first_stock = Math.min(price, first_stock);

            first_profit = Math.max(price - first_stock, first_profit);

            second_stock = Math.min(price - first_profit, second_stock);

            final_profit = Math.max(price - second_stock, final_profit);
        }

        return final_profit;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
    }
}
