package revision.graph;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int arr[] : dp) {
            Arrays.fill(arr, 1);
        }
        return LIS(0, -1, nums, dp, len);

    }

    public int LIS(int index, int preIdx, int[] nums, int[][] dp, int n) {
        if (index == n) {
            return 0;
        }
        if (preIdx != -1 && dp[index][preIdx] != 1) {
            return dp[index][preIdx];
        }

        int len1 =  LIS(index + 1, preIdx, nums, dp, n);
        int len2 = 0;
        if (preIdx == -1 || nums[index] > nums[preIdx]) {
            len2 = 1 + LIS(index + 1, index, nums, dp, n);
        }
        if(preIdx != -1){
            dp[index][preIdx]=Math.max(len1, len2);
        }
        return Math.max(len1, len2);
    }
}
