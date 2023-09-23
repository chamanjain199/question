package revision.dp;

import java.util.Arrays;

public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int total = Arrays.stream(nums).sum();

        int playerOne = predictTheWinnerRec(0, len - 1, nums, dp);
        int two = total - playerOne;
        return playerOne >= two;
    }

    public int predictTheWinnerRec(int s, int e, int[] nums, int[][] dp) {
        if (s == e) {
            return nums[s];
        }
        if (s >= nums.length || e < 0) {
            return 0;
        }
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        int choice1 = nums[s] + Math.min(predictTheWinnerRec(s + 2, e, nums, dp),
                predictTheWinnerRec(s + 1, e - 1, nums, dp));
        int choice2 = nums[e] + Math.min(predictTheWinnerRec(s + 1, e - 1, nums, dp),
                predictTheWinnerRec(s, e - 2, nums, dp));
        // which one should i select to that other player will get less in next term.
        //next person will also select such a way i will get min i my next turn so taking min
        return dp[s][e] = Math.max(choice1, choice2);
    }

    public static void main(String[] args) {
        PredictTheWinner ptw = new PredictTheWinner();
        System.out.println(ptw.predictTheWinner(new int[]{2, 4, 55, 6, 8}));
    }
}
