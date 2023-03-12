package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.Map;

public class MatrixChainMultiplication {
    static int dp[][];

    static int matrixMultiplication(int N, int arr[]) {
        dp = new int[N][N];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }

        return matrixMultiplicationTopDown(1, N - 1, arr);
    }

    static int matrixMultiplicationTopDown(int i, int j, int arr[]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = arr[i - 1] * arr[k] * arr[j] + matrixMultiplicationTopDown(i, k, arr) + matrixMultiplicationTopDown(k + 1, j, arr);
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;
    }

    static int matrixMultiplicationBottomUp(int N, int arr[]) {
        dp = new int[N][N];

        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }
        for (int arr2[] : dp
        ) {
            System.out.println(Arrays.toString(arr2));
        }
        System.out.println();
        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        int[] input = new int[]{40, 20, 30, 10, 30};

        System.out.println(matrixMultiplicationBottomUp(5, input));
    }
}
