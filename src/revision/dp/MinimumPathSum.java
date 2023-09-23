package revision.dp;

import java.util.Arrays;
import java.util.Map;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return minPathSumRec(0, 0, r-1, c-1, grid, dp);
    }

    public int minPathSumRec(int i, int j, int r, int c, int[][] grid, int[][] dp) {
        if (i == r && j == c) {
            return grid[i][j];
        }
        if (i > r) {
            return 1000000000;
        }
        if (j > c) {
            return 1000000000;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int sum = grid[i][j];
        int leftSum = minPathSumRec(i + 1, j, r, c, grid, dp);
        int rightSum = minPathSumRec(i, j + 1, r, c, grid, dp);
        return dp[i][j] = Math.max(leftSum, rightSum) + sum;
    }
}
