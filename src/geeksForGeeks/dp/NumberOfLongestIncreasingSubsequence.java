package geeksForGeeks.dp;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] cur = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(cur, 1);
        int maxi = 1;
        int ans = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if ((dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cur[i] = cur[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cur[i] += cur[j];
                    }
                }
            }
            if (dp[i] > maxi) {
                maxi = Math.max(maxi, dp[i]);
                ans = cur[i];
            } else if (dp[i] == maxi) {
                ans += cur[i];
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence obj=new NumberOfLongestIncreasingSubsequence();
        System.out.println(obj.findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}
