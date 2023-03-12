package geeksForGeeks.dp;

import java.util.Arrays;

public class UniquePaths {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        int usingRec = uniquePathsRec(m, n, 0, 0);
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int usingTopDownDp = uniquePathsTopDown(m, n, m - 1, n - 1);
        int usingBottomUp = uniquePathsBottomUp(m, n);
        int usingBottomUpSpaceOptimized = usingBottomUpSpaceOptimized(m, n);

        return usingRec;
    }

    public int uniquePathsRec(int m, int n, int i, int j) {
        if (i == (m - 1) && j == (n - 1)) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        int count = 0;
        if ((i + 1) < m) {
            count += uniquePathsRec(m, n, i + 1, j);
        }
        if ((j + 1) < n) {
            count += uniquePathsRec(m, n, i, j + 1);
        }
        return count;
    }

    public int uniquePathsTopDown(int m, int n, int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int count = 0;
        count += uniquePathsTopDown(m, n, i - 1, j);
        count += uniquePathsTopDown(m, n, i, j - 1);
        return dp[i][j] = count;
    }

    public int uniquePathsBottomUp(int m, int n) {
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    public int usingBottomUpSpaceOptimized(int m, int n) {
        int[] prevRow = new int[n];
        int[] temp;
        for (int i = 0; i < m; i++) {
            temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[0] = 1;
                    continue;
                }
                int up = prevRow[j];
                int left = 0;
                if (j > 0) {
                    left = temp[j - 1];
                }
                temp[j] = up + left;
            }
            prevRow = temp;
        }
        return prevRow[n - 1];

    }

    public int usingBottomUpSpaceOptimizedCombination(int m, int n) {
        int N = m + n - 2;
        int r = Math.min(m - 1, n - 1);
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;

    }


    public static void main(String[] args) {

    }
}
