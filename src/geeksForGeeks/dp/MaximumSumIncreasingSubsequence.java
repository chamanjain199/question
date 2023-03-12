package geeksForGeeks.dp;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    int[][] dp;

    public int maxSumIS(int arr[], int n) {
        dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return maxSumISTopDown(arr, n, 0, -1);
    }

    public int maxSumISTopDown(int arr[], int n, int i, int prev) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int notTake = maxSumISTopDown(arr, n, i + 1, prev);
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = arr[i] + maxSumISTopDown(arr, n, i + 1, i);
        }
        return dp[i][prev + 1] = Math.max(take, notTake);
    }

    public static void main(String[] args) {

    }
}
