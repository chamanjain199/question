package geeksForGeeks.dp;

import java.util.Arrays;

public class HouseRobber {
    int dp[];

    public int rob(int[] nums) {
        int len = nums.length;
        dp = new int[len];
        Arrays.fill(dp, -1);
        return robTopDown(len - 1, nums);
    }

    private int robTopDown(int n, int[] nums) {
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = robTopDown(n - 2, nums) + nums[n];
        int right = robTopDown(n - 1, nums);

        return dp[n] = Math.max(left, right);
    }

    private int robBottomUp(int n, int[] nums) {
        dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1) {
                take += dp[i - 2];
            }
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n - 1];
    }

    private int robBottomUpSpaceOptimized(int n, int[] nums) {
        int inclusive = nums[0];
        int exclusive = 0;
        for (int i = 1; i < n; i++) {
            int take = nums[i] + exclusive;
            int notTake = inclusive;
            int cur = Math.max(take, notTake);
            exclusive = inclusive;
            inclusive = cur;
        }
        return inclusive;
    }
    private int robBottomUpSpaceOptimized2(int n, int[] nums) {
        int inclusive = nums[0];
        int exclusive = 0;
        for (int i = 1; i < n; i++) {
            int take = nums[i] + exclusive;
            int cur = Math.max(take, inclusive);
            exclusive = inclusive;
            inclusive = cur;
        }
        return inclusive;
    }


    private int robGreedyAlgo(int n, int[] nums) {
        int inclusive = nums[0];
        int exclusive = 0;
        for (int i = 1; i < n; i++) {
            int max = Math.max(inclusive, exclusive);
            inclusive = nums[i] + exclusive;
            exclusive = max;  // agr mai current element ko nahi le rha to mai
                              // 1)Math.max( previous element ko add kiya ho , previous element ko add na kiya ho) le sakta hu
                              //kiyoki current to le nahi rahe to pichla le sakte hia but pichla liya ya na liya ka max le rahe be greedy
        }
        return Math.max(exclusive,inclusive);

    }
}
