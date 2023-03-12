package geeksForGeeks.dp;

import java.util.Arrays;

public class DistinctSubsequences {
    int dp[][];

    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return numDistinct(s, t, len1 - 1, len2 - 1);
    }

    public int numDistinct(String s, String t, int i, int j) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = numDistinct(s, t, i - 1, j - 1) + numDistinct(s, t, i - 1, j);
        }
        return dp[i][j] = numDistinct(s, t, i - 1, j);
    }

    public int numDistinctTabulation(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }

    public int numDistinctTabulationSpaceOptimization(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] dp = new int[len2 + 1];
        dp[0] = 1;
        int[] cur;
        for (int i = 1; i <= len1; i++) {
            cur = new int[len2 + 1];
            cur[0] = 1;
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = dp[j - 1] + dp[j];
                } else {
                    cur[j] = dp[j];
                }
            }
            dp = cur;
        }
        return dp[len2];
    }
}
