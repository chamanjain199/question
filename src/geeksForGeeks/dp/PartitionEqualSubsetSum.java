package geeksForGeeks.dp;

public class PartitionEqualSubsetSum {
    int[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if ((total & 1) == 1) {
            return false;
        }
        return canPartitionRec(n, nums, 0, total / 2);

    }

    private boolean canPartitionRec(int n, int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == n) {
            return false;
        }
        if (dp[index][target] != 0) {
            return dp[index][target] == 1;
        }

        boolean notSelect = canPartitionRec(n, nums, index + 1, target);
        boolean select = false;
        if (nums[index] <= target) {
            select = canPartitionRec(n, nums, index + 1, target - nums[index]);
        }
        dp[index][target] = (select || notSelect) ? 1 : 2;
        return dp[index][target] == 1;
    }
}
