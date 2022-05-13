package leetcode.algo.plan.one;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if(k> nums.length){
            k=k%nums.length;
        }
        k = nums.length - k;
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);

    }

    private static void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2};

        rotate(nums, 5);
        System.out.println(Arrays.toString(nums));
    }
}
