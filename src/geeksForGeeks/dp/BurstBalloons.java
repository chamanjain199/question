package geeksForGeeks.dp;

import java.util.Arrays;

public class BurstBalloons {
    int[][] dp;

    public int maxCoins(int[] nums) {
        int len = nums.length;
        dp = new int[len + 1][len + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int[] copied = new int[len + 2];
        System.arraycopy(nums, 0, copied, 1, len);
        copied[0] = 1;
        copied[copied.length - 1] = 1;
        return maxCoinsTopDown(1, len, copied);
    }

    public int maxCoinsTopDown(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int steps = nums[i - 1] * nums[k] * nums[j + 1]
                    + maxCoinsTopDown(i, k - 1, nums) + maxCoinsTopDown(k + 1, j, nums);
            max = Math.max(max, steps);
        }
        return dp[i][j] = max;
    }

    public int maxCoinsBottomUp(int[] nums) {
        int len = nums.length;
        dp = new int[len + 2][len + 2];
        int[] copied = new int[len + 2];
        System.arraycopy(nums, 0, copied, 1, len);
        copied[0] = 1;
        copied[copied.length - 1] = 1;
        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <= len; j++) {
                if (i > j) continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int steps = copied[i - 1] * copied[k] * copied[j + 1]
                            + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, steps);
                }
                dp[i][j] = max;

            }
        }
        return dp[1][len];
    }

    public static void main(String[] args) {

    }
}
