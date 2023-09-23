package revision.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        int[][] dp = new int[len][len];
        return wordBreakRec(s, 0, 1, wordSet, dp, len);
    }

    private boolean wordBreakRec(String s, int i, int j, Set<String> wordSet, int[][] dp, int len) {
        if (i == len) {
            return true;
        }
        if (j > len) {
            return false;
        }
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        boolean take = false;
        String sub = s.substring(i, j);
        if (wordSet.contains(sub)) {
            take = wordBreakRec(s, j, j + 1, wordSet, dp, len);
        }
        boolean notTake = wordBreakRec(s, i, j + 1, wordSet, dp, len);
        dp[i][j] = (take || notTake) ? 1 : 2;
        return dp[i][j] == 1;
    }
}
