package test;

import java.util.ArrayList;

public class MaximumSubArray {
    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = 0;
        long curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += Math.max(arr[i], arr[i] + curSum);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
