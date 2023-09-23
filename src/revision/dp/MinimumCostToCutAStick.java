package revision.dp;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        int[][] dp = new int[n][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return minCostRec(n, cuts, n - 1, n - 1, dp);
    }

    private int minCostRec(int n, int[] cuts, int i, int n1, int[][] dp) {
        if (i == 0) {
            return n * cuts[0];
        }
        if (dp[i][n1] != -1) {
            return dp[i][n1];
        }
        int notPick = minCostRec(n, cuts, i + 1, n1, dp);
        int pick = Integer.MIN_VALUE;
        if ((i + 1) <= n1) {
            pick = cuts[i] + minCostRec(n, cuts, i, n1 - (i + 1), dp);
        }
        return dp[i][n1] = Math.max(pick, notPick);
    }
}
