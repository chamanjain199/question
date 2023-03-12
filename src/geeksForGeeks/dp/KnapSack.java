package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.logging.SocketHandler;

public class KnapSack {
    static int dp[][];

    static int knapSack(int W, int wt[], int val[], int n) {
        dp = new int[n][W + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return knapSackTopDown(W, wt, val, n - 1);
    }

    static int knapSackTopDown(int W, int wt[], int val[], int index) {
        if (index == 0) {
            if (wt[index] <= W) {
                return val[index];
            }
            return 0;
        }
        if (dp[index][W] != -1) {
            return dp[index][W];
        }
        int notPick = knapSackTopDown(W, wt, val, index - 1);
        int pick = Integer.MIN_VALUE;
        if (wt[index] <= W) {
            pick = val[index] + knapSackTopDown(W - wt[index], wt, val, index - 1);
        }
        return dp[index][W] = Math.max(pick, notPick);
    }

    static int knapSackBottomUp(int W, int wt[], int val[], int n) {
        dp = new int[n][W + 1];
        for (int w = wt[0]; w <= W; w++) { //because you are at 0 index so you can only select 0th index weight so value is also be val[0]
            dp[0][w] = val[0];             // this is DP so it can have weight at zero index more then that but we can select only 0th weight val rest weight can not be selected
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    pick = val[i] + dp[i - 1][j - wt[i]];
                }
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][W];
    }

    static int knapSackBottomUpSpaceOptimized(int W, int wt[], int val[], int n) {
        int[] prev = new int[W + 1];
        int[] cur;
        for (int w = wt[0]; w <= W; w++) {
            prev[w] = val[0];
        }
        for (int i = 1; i < n; i++) {
            cur = new int[W + 1];
            for (int j = 0; j <= W; j++) {
                int notPick = prev[j];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    pick = val[i] + prev[j - wt[i]];
                }
                cur[j] = Math.max(pick, notPick);
            }
            prev = cur;
        }
        return prev[W];
    }
    static int knapSackBottomUpSuperSpaceOptimized(int W, int wt[], int val[], int n) {
        int[] prev = new int[W + 1];
        for (int w = wt[0]; w <= W; w++) {
            prev[w] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = W; j >=0; j--) {
                int notPick = prev[j];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j) {
                    pick = val[i] + prev[j - wt[i]];
                }
                prev[j] = Math.max(pick, notPick);
            }
        }
        return prev[W];
    }


    public static void main(String[] args) {
        System.out.println(knapSackBottomUp(5, new int[]{5, 3, 2, 4}, new int[]{40, 15, 30, 80}, 4));
    }
}