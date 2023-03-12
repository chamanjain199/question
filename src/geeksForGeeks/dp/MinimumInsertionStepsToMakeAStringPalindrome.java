package geeksForGeeks.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    static int dp[][];

    static int countMin(String str) {
        int len = str.length();
        dp = new int[len + 1][len + 1];
        String t = new StringBuilder(str).reverse().toString();

//        for (int[] a : dp) {
//            Arrays.fill(a, -1);
//        }
        return len - longestCommonSubStringBottomUp(str, t);
    }

    static int longestCommonSubStringBottomUp(String s, String t) {
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

    static int longestCommonSubString(String s, String t, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (s.charAt(index1) == t.charAt(index2)) {
            return 1 + longestCommonSubString(s, t, index1 - 1, index2 - 1);
        }
        return dp[index1][index2] = Math.max(longestCommonSubString(s, t, index1 - 1, index2), longestCommonSubString(s, t, index1, index2 - 1));
    }

    public static void main(String[] args) {
        countMin("abcd");
        System.out.println(Arrays.deepToString(dp));
    }
}
