package geeksForGeeks.dp;

import java.util.Arrays;

public class PalindromePartitioningII {
    int[] dp;
    boolean[][] palindromeDp;

    public int minCut(String s) {
        int len = s.length();
        dp = new int[len + 1];
        Arrays.fill(dp, -1);
        return minCutTopDown(0, s, len) - 1;
    }

    public int minCutTopDown(int i, String s, int len) {
        if (i == len) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < len; j++) {
            if (isPalindrome(s, i, j)) {
                int cost = 1 + minCutTopDown(j + 1, s, len);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    public int minCutBottomUp(String s) {
        int len = s.length();
        dp = new int[len + 1];
        palindromeDp = new boolean[len][len];
        for (int g = 0; g < len; g++) {
            for (int i = 0, j = g; j < len; i++, j++) {
                if (g == 0) {
                    palindromeDp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (g == 1) {
                        if (b) {
                            palindromeDp[i][j] = true;
                        }
                    } else {
                        if (b && palindromeDp[i + 1][j - 1]) {
                            palindromeDp[i][j] = true;
                        }
                    }
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (palindromeDp[i][j]) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;

    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioningII obj = new PalindromePartitioningII();
        System.out.println(obj.minCutBottomUp("efe"));
    }
}
