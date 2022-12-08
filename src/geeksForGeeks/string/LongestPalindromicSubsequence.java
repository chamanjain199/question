package geeksForGeeks.string;

public class LongestPalindromicSubsequence {
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
                    dp[k][j] = Math.max(dp[k][j - 1], dp[k + 1][j]);
                }
            }
        }
        return dp[0][len - 1];

    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
