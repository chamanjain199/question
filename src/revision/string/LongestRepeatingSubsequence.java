package revision.string;

public class LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequence(String str)
    {
        int len = str.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i!=j && str.charAt(i) == str.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len][len];
    }
}
