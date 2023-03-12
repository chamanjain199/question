package geeksForGeeks.dp;

import java.util.Arrays;

public class RodCutting {
    int[][] dp;

    public int cutRod(int price[], int n) {
        int len = price.length;
        dp = new int[len][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return cutRodTopDown(price, n, len - 1);
    }

    public int cutRodTopDown(int[] price, int n, int index) {

        if (index == 0) {
            return price[index] * n;
        }
        if (dp[index][n] != -1) {
            return dp[index][n];
        }
        int notPick = cutRodTopDown(price, n, index - 1);
        int pick = -10000;
        if ((index + 1) <= n) {
            pick = price[index] + cutRodTopDown(price, n - (index + 1), index);
        }
        return dp[index][n] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {

    }
}
