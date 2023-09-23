package revision.dp;

import java.util.Arrays;

public class PalindromicPartitioning {
    static int palindromicPartition(String str) {
        int len = str.length();
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        return palindromicPartitionRec(0, str, dp, len)-1;
    }

    static int palindromicPartitionRec(int i, String str, int[] dp, int len) {
        if (i == len) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = i; j < len; j++) {
            if (canPartition(i, j, str)) {
                min = Math.min(min, 1 + palindromicPartitionRec(j + 1, str, dp, len));
            }
        }
        return dp[i] = min;
    }

    static boolean canPartition(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
