package revision.string;

import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        dp = new int[l1][l2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return longestCommonSubsequenceHelper(text1, text2, 0, 0, l1, l2);
    }

    private int longestCommonSubsequenceHelper(String text1, String text2, int i, int j, int l1, int l2) {
        if (i >= l1 || j >= l2) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequenceHelper(text1, text2, i + 1, j + 1, l1, l2);
        } else {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            return dp[i][j] = Math.max(longestCommonSubsequenceHelper(text1, text2, i + 1, j, l1, l2),
                    longestCommonSubsequenceHelper(text1, text2, i, j + 1, l1, l2));

        }
    }

    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

}

