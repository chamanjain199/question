package revision.dp;

import java.util.Arrays;
import java.util.Map;

public class MatrixChainMultiplication {
    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return matrixMultiplicationRec(1, N - 1, arr, dp);
    }

    static int matrixMultiplicationRec(int i, int j, int[] arr, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int step = arr[i - 1] * arr[k] * arr[j] + matrixMultiplicationRec(i, k, arr, dp) + matrixMultiplicationRec(k + 1, j, arr, dp);
            mini = Math.min(mini, step);
        }
        return dp[i][j] = mini;
    }
}
