package geeksForGeeks.dp;

import java.util.Arrays;

public class ParsingABooleanExpression {
    static int[][][] dp;
    static int mod = 1003;

    static int countWays(int N, String S) {
        int len = S.length();
        dp = new int[len][len][2];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return countWays(0, len-1, 1, S);
    }

    public static int countWays(int i, int j, int isTrue, String expression) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) {
                if (expression.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (expression.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        int ways = 0;
        for (int k = i+1; k <j; k += 2) {
            int lt = countWays(i, k - 1, 1, expression);
            int lf = countWays(i, k - 1, 0, expression);
            int rt = countWays(k + 1, j, 1, expression);
            int rf = countWays(k + 1, j, 0, expression);

            if (expression.charAt(k) == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lt * rt) % mod) % mod;
                } else {
                    ways = (ways + (lt * rf) % mod + (lf * rt) % mod + (lf * rf) % mod) % mod;
                }
            } else if (expression.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lt * rf) % mod + (lf * rt) % mod + (lt * rt) % mod) % mod;
                } else {
                    ways = (ways + (lf * rf) % mod) % mod;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lt * rf) % mod + (lf * rt) % mod) % mod;
                } else {
                    ways = (ways + (lt * rt) % mod + (lf * rf) % mod) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ways;

    }
    public static void main(String[] args) {
        System.out.println(countWays(5, "T^F|F"));
     }
}
