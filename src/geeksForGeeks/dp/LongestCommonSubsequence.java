package geeksForGeeks.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        dp = new int[len1][len2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return longestCommonSubsequenceBottomUp(text1, text2, len1 - 1, len2 - 1);
    }

    public int longestCommonSubsequenceBottomUp(String text1, String text2, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + longestCommonSubsequenceBottomUp(text1, text2, index1 - 1, index2 - 1);
        }
        return dp[index1][index2] = Math.max(longestCommonSubsequenceBottomUp(text1, text2, index1 - 1, index2),
                longestCommonSubsequenceBottomUp(text1, text2, index1, index2 - 1));
    }

    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int index1 = 0; index1 < len1; index1++) {
            for (int index2 = 0; index2 < len2; index2++) {
                if (text1.charAt(index1) == text2.charAt(index2)) {
                    dp[index1 + 1][index2 + 1] = 1 + dp[index1][index2];
                } else {
                    dp[index1 + 1][index2 + 1] = Math.max(dp[index1][index2 + 1], dp[index1 + 1][index2]);

                }
            }
        }
        return dp[len1][len2];
    }

    int longestCommonSubStringBottomUp(String s, String t) {
        int len = s.length();
        dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len][len];
    }
}
