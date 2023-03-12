package geeksForGeeks.dp;

import java.util.Arrays;

public class CoinChangeII {
    int dp[][];

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        if (amount == 0) {
            return 1;
        }

        return changeTopDown(amount, coins, n - 1);
    }

    public int changeTopDown(int amount, int[] coins, int index) {
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int notPick = changeTopDown(amount, coins, index - 1);
        int pick = 0;
        if (coins[index] <= amount) {
            pick = changeTopDown(amount - coins[index], coins, index);
        }
        return dp[index][amount] = (pick + notPick);
    }

    public int changeBottomUp(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = (i % coins[0]) == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = (pick + notPick);
            }
        }
        return dp[n - 1][amount];
    }

    public int changeBottomUpSpaceOptimized(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = (i % coins[0]) == 0 ? 1 : 0;
        }
        int[] cur;
        for (int i = 1; i < n; i++) {
            cur = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int notPick = dp[j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = cur[j - coins[i]];
                }
                cur[j] = (pick + notPick);
            }
            dp = cur;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        CoinChangeII obj = new CoinChangeII();
        System.out.println(obj.change(4, input));
    }
}
