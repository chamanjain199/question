package geeksForGeeks.dp;

public class SuperEggDrop {
    int dp[][];

    public int superEggDrop(int k, int n) {
        dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int l = 0, m = j - 1; l < j; l++, m--) {
                        min = Math.min(min, Math.max(dp[i - 1][l], dp[i][m]));
                    }
                    dp[i][j] = min + 1;
                }

            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {

    }
}
