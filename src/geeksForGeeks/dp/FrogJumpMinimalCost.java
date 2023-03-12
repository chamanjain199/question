package geeksForGeeks.dp;

import java.util.Arrays;

public class FrogJumpMinimalCost {
    int dp[];

    public int minimizeCost(int arr[], int N, int K) {
        dp = new int[N + 1];

        Arrays.fill(dp, -1);
        int topDown = topDown(arr, N - 1, K);
        dp = new int[N + 1];
        int bottomUp = bottomUp(arr, N - 1, K);
        return topDown;

    }

    public int topDown(int arr[], int N, int K) {
        if (dp[N] != -1) {
            return dp[N];
        }
        if (N == 0) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i <= K; i++) {
            int tempMinCost;
            if (N - i >= 0) {
                tempMinCost = topDown(arr, N - i, K) + Math.abs(arr[N] - arr[N - i]);
                minCost = Math.min(tempMinCost, minCost);
            }
        }
        dp[N] = minCost;
        return minCost;
    }

    public int bottomUp(int arr[], int N, int K) {
        dp=new int[N+1];
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= K; j++) {
                int tempMinCost;
                if (i - j >= 0) {
                    tempMinCost = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minCost = Math.min(tempMinCost, minCost);
                }
            }
            dp[i] = minCost;
        }
        return dp[N-1];
    }


    public static void main(String[] args) {
        FrogJumpMinimalCost frogJumpMinimalCost = new FrogJumpMinimalCost();
        System.out.println(frogJumpMinimalCost.minimizeCost(new int[]{10, 30, 40, 50, 20}, 5, 3));
    }
}
