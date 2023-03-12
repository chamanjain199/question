package geeksForGeeks.dp;

public class MinimumNumberOfDeletionsAndInsertions {
    int dp[][];

    public int minOperations(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        dp = new int[len1 + 1][len2 + 1];
        return len1 + len2 - 2*(longestCommonSubStringBottomUp(str1, str2));

    }

    int longestCommonSubStringBottomUp(String s, String t) {
        int len = s.length();
        int len2 = t.length();
        dp = new int[len + 1][len2 + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len][len2];
    }
}
