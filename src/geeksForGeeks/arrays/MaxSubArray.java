package geeksForGeeks.arrays;

import java.util.Arrays;

public class MaxSubArray {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int maxCircularSubArray(int[] nums) {
        int len = nums.length;
        int maxSubArray = maxSubArray(nums);
        if(maxSubArray<0){
            return maxSubArray;
        }
        int total=0;
        for (int i = 0; i < len; i++) {
            total+=nums[i];
            nums[i]=(-nums[i]);
        }
        int minSubArray = maxSubArray(nums);
        return Math.max(maxSubArray,total+minSubArray);

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
