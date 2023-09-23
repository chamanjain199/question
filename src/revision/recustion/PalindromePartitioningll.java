package revision.recustion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningll {
    Map<String, Boolean> map;
    int[] dp;
    int[][] paldp;

    public int minCut(String s) {
        map = new HashMap<>();
        int length = s.length();

        dp = new int[length];
        paldp = new int[length][length];

        Arrays.fill(dp, -1);
        for (int[] arr : paldp
        ) {
            Arrays.fill(arr, -1);
        }
        if (isPalindrome(s, 0, length - 1)) {
            return 0;
        }
        return minCutRec(s, length, 0) - 1;
    }

    private int minCutRec(String s, int len, int index) {
        int minCut = Integer.MAX_VALUE;
        if (index == len) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        for (int i = index; i < len; i++) {
            if (isPalindrome(s, index, i)) {
                int cost = 1 + minCutRec(s, len, i + 1);
                minCut = Math.min(minCut, cost);
            }
        }
        return dp[index] = minCut;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (paldp[start][end] != -1) {
                return paldp[start][end] > 0;
            }
            if (s.charAt(start++) != s.charAt(end--)) {
                paldp[start][end] = -2;
                return false;
            }
        }
        paldp[start][end] = 1;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioningll obj = new PalindromePartitioningll();
        System.out.println(obj.minCut("aab"));
    }
}
