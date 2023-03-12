package geeksForGeeks.dp;

public class LongestPalindromicSubsequence {
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequenceTopDown(s, t);
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

    public int longestPalindromeSubseq2(String s) {
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
            for (int j = i, k = 0; j < len; k++, j++) {
                if (s.charAt(k) == s.charAt(j)) {
                    dp[k][j] = 2 + dp[k + 1][j - 1];
                } else {
                    dp[k][j] = Math.max(dp[k][j - 1], dp[k + 1][j]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
