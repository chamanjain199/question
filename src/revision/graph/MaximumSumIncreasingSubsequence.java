package revision.graph;

import java.util.Arrays;
import java.util.Map;

public class MaximumSumIncreasingSubsequence {
    public int maxSumIS(int arr[], int n) {
        int[][] dp = new int[n][n];
        for (int[] mr : dp) {
            Arrays.fill(mr, -1);
        }
        return maxSumISRec(arr, n, 0, 0, dp);
    }

    public int maxSumISRec(int arr[], int n, int i, int pre, int[][] dp) {
        if (i >= n) {
            return 0;
        }
        if (pre != -1 && dp[i][pre] != -1) {
            return dp[i][pre];
        }
        int npick = maxSumISRec(arr, n, i + 1, pre, dp);
        int pick = Integer.MIN_VALUE;
        if (pre == -1 || arr[i] > arr[pre]) {
            pick = arr[i] + maxSumISRec(arr, n, i + 1, i, dp);
        }
        if (pre != -1) {
            return dp[i][pre] = Math.max(pick, npick);
        }
        return Math.max(pick, npick);
    }
}
