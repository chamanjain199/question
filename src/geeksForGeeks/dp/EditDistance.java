package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.Map;

public class EditDistance {
    int dp[][];

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return minDistanceTopDown(word1, word2, len1 - 1, len2 - 1);
    }

    private int minDistanceTopDown(String word1, String word2, int i, int j) {
        if (j < 0) {
            return i + 1;
        }
        if (i < 0) {
            return j + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistanceTopDown(word1, word2, i - 1, j - 1);
        } else {
            return dp[i][j] = 1 + Math.min(Math.min(minDistanceTopDown(word1, word2, i, j - 1), minDistanceTopDown(word1, word2, i - 1, j)), minDistanceTopDown(word1, word2, i - 1, j - 1));
        }
    }

    public int minDistanceBottomUp(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }

        }
        return dp[len1][len2];
    }

    public int minDistanceBottomUpSpaceOptimized(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2 + 1];
        int[] cur;
        for (int i = 0; i <= len2; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            cur = new int[len2 + 1];
            cur[0] = i;
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = dp[j - 1];
                } else {
                    cur[j] = 1 + Math.min(Math.min(cur[j - 1], dp[j]), dp[j - 1]);
                }
            }
            dp = cur;

        }
        return dp[len2];
    }

    public static void main(String[] args) {

    }
}
