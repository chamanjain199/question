package revision.graph;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return longestCommonSubsequenceRec(text1, text2, 0, 0, dp);
    }

    public int longestCommonSubsequenceRec(String text1, String text2, int i, int j, int[][] dp) {

        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequenceRec(text1, text2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(longestCommonSubsequenceRec(text1, text2, i + 1, j, dp)
                    , longestCommonSubsequenceRec(text1, text2, i, j + 1, dp));
        }

    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj=new LongestCommonSubsequence();
        obj.longestCommonSubsequence("abc","def");
    }
}
