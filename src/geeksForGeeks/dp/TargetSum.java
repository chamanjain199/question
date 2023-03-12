package geeksForGeeks.dp;

import java.util.Arrays;
import java.util.HashMap;

public class TargetSum {
    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return findTargetSumWaysTopDown(nums, target, n - 1, 0);
    }

    public int findTargetSumWaysTopDown(int nums[], int target, int index, int curTarget) {
        if (index == 0) {
            if (curTarget + nums[0] == target) {
                return 1;
            } else if (curTarget - nums[0] == target) {
                return 1;
            }
            return 0;
        }

        int withPlus = findTargetSumWaysTopDown(nums, target, index - 1, curTarget + nums[index]);
        int withMinus = findTargetSumWaysTopDown(nums, target, index - 1, curTarget - nums[index]);
        return withPlus + withMinus;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int s : nums) {
            total += s;
        }
        int targetUpdated = (total - target) / 2;
        if (total - target < 0) return 0;
        if ((total - target) % 2 == 1) return 0;

        dp = new int[n][targetUpdated + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return findTargetSumWaysTopDownOptimized(nums, targetUpdated, n - 1);
    }

    // this question is same as PartitionsWithGivenDifference
    public int findTargetSumWaysTopDownOptimized(int nums[], int target, int index) {
        if (index == -1) {
            return target == 0 ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = findTargetSumWaysTopDownOptimized(nums, target, index - 1);
        int pick = 0;
        if (nums[index] <= target) {
            pick = findTargetSumWaysTopDownOptimized(nums, target - nums[index], index - 1);
        }
        return dp[index][target] = notPick + pick;
    }

    public static void main(String[] args) {
        TargetSum obj = new TargetSum();
        int nums[] = new int[]{1, 1, 1, 1, 1};
        System.out.println(obj.findTargetSumWays(nums, 3));
    }
}
