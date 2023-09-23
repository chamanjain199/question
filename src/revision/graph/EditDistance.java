package revision.graph;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minDistanceRec(0, 0, word1, word2, dp, len1, len2);
    }

    public int minDistanceRec(int i, int j, String word1, String word2, int[][] dp, int len1, int len2) {
        Executors.newFixedThreadPool(10);
        if (i == len1) {
            return len2 - j;
        }
        if (j == len2) {
            return len1 - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistanceRec(i + 1, j + 1, word1, word2, dp, len1, len2);
        } else {
            return dp[i][j] = 1 + Math.min(minDistanceRec(i + 1, j + 1, word1, word2, dp, len1, len2), Math.min(
                    minDistanceRec(i, j + 1, word1, word2, dp, len1, len2),
                    minDistanceRec(i + 1, j, word1, word2, dp, len1, len2)
            ));
        }
    }
}
