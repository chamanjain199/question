package geeksForGeeks.dp;

import java.util.Arrays;

public class SuperEggDrop {
    static int eggDrop(int n, int k)
    {
        int dp[][];
        dp = new int[n+1][k+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return superEggDrop(n,k,dp);
    }
    public static int superEggDrop(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) {
            return f;
        }
        if (e == 1) {
            return f;
        }
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        int pick = Integer.MAX_VALUE;
        for (int k = 1; k <=f; k++) {
            int worse =1+ Math.max(superEggDrop(e - 1, k - 1, dp), superEggDrop(e, f - k, dp));
            pick = Math.min(worse, pick);
        }
        return dp[e][f]=pick;
    }
    public static void main(String[] args) {
        System.out.println(eggDrop(2, 10));
    }
}
