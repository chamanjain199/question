package geeksForGeeks.recurtion;

import java.util.Arrays;

public class PredictTheWinner {

    int dp[][];

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if ((len & 1) == 0) {
            return true;
        }
        dp = new int[len][len];
        for (int[] dp1 : dp) {
            Arrays.fill(dp1, -1);
        }
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        int one = predictTheWinnerHelper(nums, 0, len - 1);
        int two = total - one;
        return one >= two;

    }

    public boolean PredictTheWinnerDP(int[] nums) {
        int len = nums.length;
        if ((len & 1) == 0) {
            return true;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        dp = new int[len][len];
        for (int g = 0; g < len; g++) {
            for (int i = 0, j = g; j < len; i++,j++) {
                if (g == 0) {
                    dp[i][j] = nums[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    dp[i][j] = Math.max(nums[i] +
                                    Math.min(dp[i + 2][j],
                                            dp[i + 1][j - 1]),
                            nums[j] + Math.min(dp[i + 1][j - 1],
                                    dp[i][j - 2]));
                }
            }
        }
        int one = dp[0][len - 1];
        int two = total - one;
        return one >= two;
    }

    public int predictTheWinnerHelper(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        if (s >= nums.length || e < 0) {
            return 0;
        }
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        return dp[s][e] = Math.max(nums[s] +
                        Math.min(predictTheWinnerHelper(nums, s + 2, e),
                                predictTheWinnerHelper(nums, s + 1, e - 1)),
                nums[e] + Math.min(predictTheWinnerHelper(nums, s + 1, e - 1),
                        predictTheWinnerHelper(nums, s, e - 2)));

    }


    public static void main(String[] args) {
        PredictTheWinner pw = new PredictTheWinner();
        System.out.println(pw.PredictTheWinnerDP(new int[]{
                1, 5, 2}));
    }


}
