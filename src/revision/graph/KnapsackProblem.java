package revision.graph;


import java.util.Arrays;

public class KnapsackProblem {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int dp[][] = new int[n][W+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return knapSackRec(0, W, wt, val, 0, dp);
    }
    private static int knapSackRec(int i, int w, int[] wt, int[] val, int n, int[][] dp) {
        if (n == val.length) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int npick = knapSackRec(i + 1, w, wt, val, n+1, dp);
        int pick = Integer.MIN_VALUE;
        if (wt[i] <= w) {
            pick = val[i] + knapSackRec(i+1, w - wt[i], wt, val, n+1, dp);
        }
        return dp[i][w] = Math.max(npick, pick);
    }
}
