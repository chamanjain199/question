package revision.dp;

import java.util.Arrays;

public class RodCut {
    int[][] dp;
    public int minCost(int n, int[] cuts) {

        int len = cuts.length;
        int copy[] = new int[len + 2];
        System.arraycopy(cuts, 0, copy, 1, len);
        dp = new int[len+ 1][len + 1];

        copy[copy.length - 1] = n;
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        Arrays.sort(copy);
        return minCostRec(copy, dp, 1, len);
    }

    public int minCostRec(int[] cuts, int[][] dp, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + minCostRec(cuts, dp, i, k - 1) + minCostRec(cuts, dp, k + 1, j);
            min = Math.min(min, cost);
        }
        return dp[i][j]=min;
    }
}
