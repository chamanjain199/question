package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.List;

public class TrianglePathSum {
    int dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.size();
        dp = new int[depth][depth];
        for (int i = 0; i < depth; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int ansRec = minimumTotalRecursion(triangle, depth, 0, 0);
        return ansRec;

    }

    private int minimumTotalRecursion(List<List<Integer>> triangle, int depth, int i, int j) {
        if (i == depth - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int cur = triangle.get(i).get(j);
        int down = cur + minimumTotalRecursion(triangle, depth, i + 1, j);
        int downDg = cur + minimumTotalRecursion(triangle, depth, i + 1, j + 1);
        return dp[i][j] = Math.min(down, downDg);
    }

    private int minimumTotalTabulation(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int[][] dp = new int[depth][depth];
        for (int i = 0; i < depth; i++) {
            dp[depth - 1][i] = triangle.get(depth - 1).get(i);
        }
        for (int i = depth - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int cur = triangle.get(i).get(j);
                int down = cur + dp[i + 1][j];
                int downDg = cur + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, downDg);
            }
        }
        return dp[0][0];
    }

    private int minimumTotalTabulationSpaceOptimization(List<List<Integer>> triangle) {
        int depth = triangle.size();
        int[] dp = new int[depth];
        for (int i = 0; i < depth; i++) {
            dp[i] = triangle.get(depth - 1).get(i);
        }
        for (int i = depth - 2; i >= 0; i--) {
            int[] temp = new int[i + 1];
            for (int j = i; j >= 0; j--) {
                int cur = triangle.get(i).get(j);
                int down = cur + dp[j];
                int downDg = cur + dp[j + 1];
                temp[j] = Math.min(down, downDg);
            }
            dp = temp;
        }
        return dp[0];
    }

}
