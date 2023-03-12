package geeksForGeeks.dp;

public class LongestCommonSubstring {
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] memo = new int[n + 1][m + 1];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (S1.charAt(i) == S2.charAt(j)) {
                    memo[i + 1][j + 1] = 1 + memo[i][j];
                    maxValue = Math.max(memo[i + 1][j + 1], maxValue);
                }
            }
        }
        return maxValue;
    }
}
