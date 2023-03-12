package geeksForGeeks.dp;

import java.util.Arrays;

public class MinimumFallingPathSum {

    int dp[][];

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            minSum = Math.min(minFallingPathSumRec(matrix, 0, i, row - 1, col - 1), minSum);
            dp[0][i] = Math.min(minSum, dp[0][i]);
        }
        return minSum;
    }

    public int minFallingPathSumRec(int[][] matrix, int curRow, int curCol, int row, int col) {
        if (curCol < 0 || curCol > col) {
            return 100000;
        }
        if (curRow == row) {
            return matrix[curRow][curCol];
        }
        if (dp[curRow][curCol] != Integer.MAX_VALUE) {
            return dp[curRow][curCol];
        }
        int newSum = matrix[curRow][curCol];
        int left = newSum + minFallingPathSumRec(matrix, curRow + 1, curCol - 1, row, col);
        int same = newSum + minFallingPathSumRec(matrix, curRow + 1, curCol, row, col);
        int right = newSum + minFallingPathSumRec(matrix, curRow + 1, curCol + 1, row, col);
        return dp[curRow][curCol] = Math.min(Math.min(left, same), right);
    }

    public int minFallingPathSumBottomUp(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        System.arraycopy(matrix[row - 1], 0, dp[row - 1], 0, row);
        int minSum = Integer.MAX_VALUE;
        for (int i = row - 2; i > -1; i--) {
            for (int j = 0; j < col; j++) {
                int left = 100000;
                int right = 100000;
                if (j > 0)
                    left = matrix[i][j] + dp[i + 1][j - 1];
                int same = matrix[i][j] + dp[i + 1][j];
                if (j < col - 1)
                    right = matrix[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(same, Math.min(left, right));
            }
        }
        for (int i = 0; i < row; i++) {
            minSum = Math.min(minSum, dp[0][i]);
        }
        return minSum;
    }

    public int minFallingPathSumBottomUpSpaceOptimized(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[row];
        System.arraycopy(matrix[row - 1], 0, dp, 0, row);
        int minSum = Integer.MAX_VALUE;
        int[] temp;
        for (int i = row - 2; i > -1; i--) {
            temp = new int[row];
            for (int j = 0; j < col; j++) {
                int left = 100000;
                int right = 100000;
                if (j > 0)
                    left = matrix[i][j] + dp[j - 1];
                int same = matrix[i][j] + dp[j];
                if (j < col - 1)
                    right = matrix[i][j] + dp[j + 1];
                temp[j] = Math.min(same, Math.min(left, right));
            }
            dp = temp;
        }
        for (int i = 0; i < row; i++) {
            minSum = Math.min(minSum, dp[i]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        int[][] input = new int[][]{{100, -42, -46, -41}, {31, 97, 10, -10}, {-58, -51, 82, 89}, {51, 81, 69, -51}};

        //  input = new int[][]{{-47}};
        //input = new int[][]{{17, 82}, {1, -44}};
        System.out.println(obj.minFallingPathSum(input));
        System.out.println(obj.minFallingPathSumBottomUp(input));
        System.out.println(obj.minFallingPathSumBottomUpSpaceOptimized(input));


    }
}
