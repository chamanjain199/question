package revision.string;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    int[][] dp;

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 1;
            }
        }
        for (int i = 2; i < len; i++) {
            for (int j = i, k = 0; j < len; j++, k++) {
                if (s.charAt(k) == s.charAt(j)) {
                    dp[k][j] = 2 + dp[k + 1][j - 1];
                } else {
                    dp[k][j] = Math.max(dp[k + 1][j], dp[k][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public int longestPalindromeSubseqOptimized(String s) {
        int len = s.length();
        dp = new int[len][len];
        for (int[] arr : dp
        ) {
            Arrays.fill(arr, -1);
        }
        return longestPalindromeSubseqOptimizedHelper(s, new StringBuilder(s).reverse().toString(), 0, 0, len);
    }

    public int longestPalindromeSubseqOptimizedHelper(String s1, String s2, int i, int j, int len) {
        if (i >= len || j >= len) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestPalindromeSubseqOptimizedHelper(s1, s2, i + 1, j + 1, len);
        } else {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            return dp[i][j] = Math.max(longestPalindromeSubseqOptimizedHelper(s1, s2, i, j + 1, len)
                    , longestPalindromeSubseqOptimizedHelper(s1, s2, i + 1, j, len));
        }
    }
}
