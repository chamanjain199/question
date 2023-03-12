package geeksForGeeks.dp;

import java.util.Arrays;

public class MinimumPathSum {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minPathSum(row - 1, col - 1, grid);
    }

    public int minPathSum(int r, int c, int[][] grid) {
        if (r == 0 && c == 0) {
            return grid[0][0];
        }
        if (r < 0 || c < 0) {
            return 10000000;
        }
        int up = grid[r][c] + minPathSum(r - 1, c, grid);
        int left = grid[r][c] + minPathSum(r, c - 1, grid);
        return Math.min(up, left);
    }

    public int minPathSumTopDown(int r, int c, int[][] grid) {
        if (r == 0 && c == 0) {
            return grid[0][0];
        }
        if (r < 0 || c < 0) {
            return 10000000;
        }
        if (dp[r][c] != -1) return dp[r][c];
        int up = grid[r][c] + minPathSumTopDown(r - 1, c, grid);
        int left = grid[r][c] + minPathSumTopDown(r, c - 1, grid);
        return dp[r][c] = Math.min(up, left);
    }

    public int minPathSumBottomUp(int r, int c, int[][] grid) {
        dp = new int[r][c];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) continue;
                int up = 10000000;
                int left = 10000000;
                int sum = grid[i][j];
                if (i > 0) {
                    up = sum + dp[i - 1][j];
                }
                if (j > 0) {
                    left = sum + dp[i][j - 1];
                }
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[r - 1][c - 1];
    }


    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] input = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minimumPathSum.minPathSum(input));
    }

}
