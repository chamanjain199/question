package revision.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int total = Arrays.stream(nums).sum();
        if ((total & 1) == 1) return false;

        int amount = total / 2;
        int[][] dp = new int[len][amount+1];
        return canPartitionRec(0, amount, nums, dp);
    }

    private boolean canPartitionRec(int i, int amount, int[] nums, int[][] dp) {
        if (i == nums.length) {
            return false;
        }
        if (amount == 0) {
            return true;
        }
        if (dp[i][amount] != 0) {
            return dp[i][amount] == 1;
        }
        boolean npick = canPartitionRec(i + 1, amount, nums, dp);
        boolean pick = false;
        if (nums[i] <= amount) {
            pick = canPartitionRec(i + 1, amount - nums[i], nums, dp);
        }
        dp[i][amount] = (pick || npick) ? 1 : 2;
        return dp[i][amount] == 1;
    }
}
