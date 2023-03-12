package geeksForGeeks.dp;

import java.util.Arrays;

public class WildcardMatching {
    int dp[][];

    public boolean isMatch(String s, String p) {

        int len1 = s.length();
        int len2 = p.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return isMatch(s, p, len1 - 1, len2 - 1);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0 && j >= 0) {
            return false;
        }
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (s.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i) == '?' || s.charAt(i) == p.charAt(j)) {
            dp[i][j] = isMatch(s, p, i - 1, j - 1) ? 1 : 0;
            return dp[i][j] == 1;

        }
        if (s.charAt(i) == '*') {
            dp[i][j] = (isMatch(s, p, i - 1, j) || isMatch(s, p, i, j - 1)) ? 1 : 0;
            return dp[i][j] == 1;
        }
        dp[i][j] = 0;
        return false;
    }

    public boolean isMatchTopDown(String s, String p) {

        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            boolean flag = true;
            for (int k = 1; k <= i; k++) {
                if (s.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (s.charAt(i - 1) == '*') {
                    dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatchTopDown("c*a*b", "aab"));
    }
}
