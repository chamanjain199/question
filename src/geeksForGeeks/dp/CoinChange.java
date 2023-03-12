package geeksForGeeks.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    int[][] dp;
    int MAX = 10000000;
    List<Integer> ans;

    public int coinChange(int[] coins, int amount) {
        ans = new ArrayList<>();
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        int output = coinChangeTopDown(coins, amount, n - 1);
        return output >= MAX ? -1 : output;
    }

    public int coinChangeTopDown(int[] coins, int amount, int index) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[index];
            }
            return 10000000;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int notPick = coinChangeTopDown(coins, amount, index - 1);
        int pick = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            pick = 1 + coinChangeTopDown(coins, amount - coins[index], index);
        }
        return dp[index][amount] = Math.min(pick, notPick);
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = 10000000;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    pick = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        return dp[n - 1][amount] >= 10000000 ? -1 : dp[n - 1][amount];
    }

    public int coinChangeBottomUpSpaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
            } else {
                prev[i] = 10000000;
            }
        }
        int[] cur;
        for (int i = 1; i < n; i++) {
            cur = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int notPick = prev[j];
                int pick = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    pick = 1 + cur[j - coins[i]];
                }
                cur[j] = Math.min(pick, notPick);
            }
            prev = cur;
        }
        return prev[amount] >= 10000000 ? -1 : prev[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{2, 5, 10, 1}, 27));
        System.out.println(cc.ans);
    }
}
