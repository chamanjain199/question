package geeksForGeeks.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class MinimumCostToCutAStick {
    int dp[][];

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] copy = new int[len + 2];
        System.arraycopy(cuts, 0, copy, 1, len);
        copy[copy.length - 1] = n;
        dp = new int[len + 1][len + 1];
        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }
        Arrays.sort(copy);
        return minCutTopDown(1, len, copy);
    }

    private int minCutTopDown(int i, int j, int[] arr) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int minStep = arr[j + 1] - arr[i - 1] + minCutTopDown(i, ind - 1, arr) + minCutTopDown(ind + 1, j, arr);
            min = Math.min(min, minStep);
        }
        return dp[i][j] = min;
    }

    private int minCutBottomUp(int n, int[] cuts) {
        int len = cuts.length;
        int[] copy = new int[len + 2];
        System.arraycopy(cuts, 0, copy, 1, len);
        copy[copy.length - 1] = n;
        dp = new int[len + 2][len + 2];

        Arrays.sort(copy);

        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <=len; j++) {
                if (i > j) continue;
                int min = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int minStep = copy[j + 1]- copy[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    min = Math.min(min, minStep);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][len ];
    }
}
