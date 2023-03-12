package geeksForGeeks.dp;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        dp = new int[len];
        Arrays.fill(dp, -1);
        return maxSumAfterPartitioningTopDown(arr, k, 0, len);
    }

    public int maxSumAfterPartitioningTopDown(int[] arr, int k, int index, int len) {
        if (index >= len) {
            return 0;
        }
        int length = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        if (dp[index] != -1) {
            return dp[index];
        }
        for (int i = index; i < index + k && i < len; i++) {
            length++;
            max = Math.max(max, arr[i]);
            maxSum = Math.max(maxSum, length * max + maxSumAfterPartitioningTopDown(arr, k, i + 1, len));
        }
        return dp[index] = maxSum;
    }

    public int maxSumAfterPartitioningBottomUp(int[] arr, int k) {
        int len = arr.length;
        dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            int length = 0;
            int max = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(len, i + k); j++) {
                length++;
                max = Math.max(max, arr[j]);
                maxSum = Math.max(maxSum, length * max + dp[j + 1]);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
