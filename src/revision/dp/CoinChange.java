package revision.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len1 = coins.length;
        int[][] dp = new int[len1][amount+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int cn = coinChangeRec(coins, amount, dp, 0);
        return cn == 100000000 ? -1 : cn;
    }

    public int coinChangeRec(int[] coins, int amount, int[][] dp, int i) {
        if (i == coins.length - 1) {
            if (amount % coins[i] == 0) {
                return amount / coins[i];
            }
            return 100000000;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int notPick = coinChangeRec(coins, amount, dp, i + 1);
        int pick = 100000000;
        if (coins[i] <= amount) {
            pick = 1 + coinChangeRec(coins, amount - coins[i], dp, i);
        }
        return dp[i][amount] = Math.min(pick, notPick);
    }
}
