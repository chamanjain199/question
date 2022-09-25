package geeksForGeeks.recurtion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningll {

    public int partition(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);
        return partitionHelper(s, 0, len, dp) - 1;
    }

    private int partitionHelper(String s, int i, int length, int[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }
        if (i == length) {
            return 0;
        }
        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < length; j++) {
            if (isPalindrome(s, i, j)) {
                minCuts = Math.min(minCuts, 1 + partitionHelper(s, j + 1, length, dp));
            }
        }
        return dp[i] = minCuts;
    }

    private int partitionDP(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            int minCuts = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j)) {
                    minCuts = Math.min(minCuts, 1 + dp[j + 1]);
                }
            }
            dp[i]=minCuts;
        }
        return dp[0] -1;
    }


    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioningll palindromePartitioningll = new PalindromePartitioningll();
        System.out.println(palindromePartitioningll.partitionDP("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));

    }
}

