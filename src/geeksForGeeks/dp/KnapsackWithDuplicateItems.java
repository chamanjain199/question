package geeksForGeeks.dp;

import java.util.Arrays;

public class KnapsackWithDuplicateItems {
    static int dp[][];
    static int knapSack(int N, int W, int val[], int wt[])
    {
        dp = new int[N][W + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return knapSackTopDown(W, wt, val, N - 1);
    }
    static int knapSackTopDown(int W, int wt[], int val[], int index) {
        if (index == 0) {
            if (wt[index] <= W) {
                return val[index]*(W/wt[index]);
            }
            return 0;
        }
        if (dp[index][W] != -1) {
            return dp[index][W];
        }
        int notPick = knapSackTopDown(W, wt, val, index - 1);
        int pick = Integer.MIN_VALUE;
        if (wt[index] <= W) {
            pick = val[index] + knapSackTopDown(W - wt[index], wt, val, index);
        }
        return dp[index][W] = Math.max(pick, notPick);
    }
}
