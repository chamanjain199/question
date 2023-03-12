package geeksForGeeks.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinimumNumberOfCoinsDP {

    public static int fun(List<Integer> vec, int N, int n, List<Integer> ans, Integer[][] dp) {
        if (N == 0) {
            return 0;
        }
        if (n == 0) {
            ans.add(vec.get(0));
            return N / vec.get(0);
        }
        if (dp[n][N] != null) {
            return dp[n][N];
        }

        int pick = Integer.MAX_VALUE;
        if (N >= vec.get(n)) {
            ans.add(vec.get(n));
            pick = 1 + fun(vec, N - vec.get(n), n, ans, dp);
        }
        int notpick = fun(vec, N, n - 1, ans, dp);

        return dp[n][N] = Math.min(pick, notpick);
    }

    public static List<Integer> minPartition(int N) {
        List<Integer> vec = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000);
        int n = vec.size();
        Integer[][] dp = new Integer[n][N + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], null);
        }
        List<Integer> ans = new ArrayList<>();
        int val = fun(vec, N, n - 1, ans, dp);
        List<Integer> ans1 = new ArrayList<>();
        for (int i = 0; i < val; i++) {
            ans1.add(ans.get(i));
        }
        return ans1;
    }

    public static void main(String[] args) {
        System.out.println(minPartition(26));
    }
}
