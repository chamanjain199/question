package geeksForGeeks.arrays;

import java.util.ArrayList;

public class MaximumSubSequenceOfSizeK {
    public static int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // while ()

        }

        return null;
    }

    public static int maxSumSubsequence(int[] nums, int k) {
        int len = nums.length;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        for (int i = k; i < len; i++) {
            maxSum = Math.max(maxSum, maxSum - nums[i - k] + nums[i]);
        }

        return maxSum;
    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int len = Arr.size();
        long maxSum = 0;

        for (int i = 0; i < K; i++) {
            maxSum += Arr.get(i);
        }
        long currSum = maxSum;
        for (int i = K; i < len; i++) {
            currSum += Arr.get(i) - Arr.get(i - K);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubsequence(new int[]{-1, -2, 3, 4}, 3));

    }
}
