package geeksForGeeks.dp;

import java.util.Arrays;

public class ChocolatesPickup {
    int[][][] dp;

    public int solve(int n, int m, int grid[][]) {
        dp = new int[n][m][m];
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return solveRec(n - 1, m - 1, grid, 0, 0, m - 1);
    }

    public int solveRec(int row, int col, int[][] grid, int curRow, int curCol1, int curCol2) {
        if (curCol1 < 0 || curCol2 < 0 || curCol1 > col || curCol2 > col) {
            return -1000000;
        }
        if (curRow == row) {
            if (curCol1 == curCol2) {
                return grid[row][curCol1];
            } else {
                return grid[row][curCol1] + grid[row][curCol2];
            }
        }
        if (dp[curRow][curCol1][curCol2] != -1) {
            return dp[curRow][curCol1][curCol2];
        }
        int maxi = -1000000;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (curCol1 == curCol2) {
                    maxi = Math.max(maxi, grid[curRow][curCol1] + solveRec(row, col, grid, curRow + 1, curCol1 + i, curCol2 + j));
                } else {
                    maxi = Math.max(maxi, grid[curRow][curCol1] + grid[curRow][curCol2] + solveRec(row, col, grid, curRow + 1, curCol1 + i, curCol2 + j));

                }
            }
        }
        return dp[curRow][curCol1][curCol2] = maxi;
    }

    public int solveBottomUp(int n, int m, int grid[][]) {
        dp = new int[n][m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    dp[n - 1][i][j] = grid[n - 1][i];
                } else {
                    dp[n - 1][i][j] = grid[n - 1][i] + grid[n - 1][j];
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = -1000000;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if ((j1 + k) >= 0 && (j2 + l) >= 0 && (j1 + k) < m && (j2 + l) < m) {
                                value += dp[i + 1][j1 + k][j2 + l];
                            } else {
                                value = -1000000;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    public int solveBottomUpSpaceOptimized(int n, int m, int grid[][]) {
        int[][] dp = new int[m][m];
        int[][] cur = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    dp[i][j] = grid[n - 1][i];
                } else {
                    dp[i][j] = grid[n - 1][i] + grid[n - 1][j];
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = -1000000;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if ((j1 + k) >= 0 && (j2 + l) >= 0 && (j1 + k) < m && (j2 + l) < m) {
                                value += dp[j1 + k][j2 + l];
                            } else {
                                value = -1000000;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }
            for (int a = 0; a < m; a++) {
                dp[a] = (cur[a].clone());
            }
        }
        return dp[0][m - 1];
    }

    public static void main(String[] args) {

    }
}
