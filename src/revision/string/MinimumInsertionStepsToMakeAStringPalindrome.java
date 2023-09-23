package revision.string;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        String s1 = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == s1.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return len - dp[len][len];
    }


}
