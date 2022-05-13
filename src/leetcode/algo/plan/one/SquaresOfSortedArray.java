package leetcode.algo.plan.one;

import java.util.ArrayList;
import java.util.Arrays;

public class SquaresOfSortedArray {
    public static int[] sortedSquaresInnerToOuter(int[] nums) {

        int arr[] = new int[nums.length];
        int secondP = -1;
        for (int i = 0; i < nums.length; i++) {
            if (secondP == -1 && nums[i] > -1) {
                secondP = i;
            }
            nums[i] = nums[i] * nums[i];
        }
        int left = secondP - 1;
        if (secondP == -1) {
            left = nums.length - 1;
        }
        for (int i = 0; i < nums.length; ) {
            if (left > -1 && secondP < nums.length && secondP > -1) {
                if (nums[left] > nums[secondP]) {
                    arr[i++] = nums[secondP];
                    secondP++;
                } else {
                    arr[i++] = nums[left];
                    left--;
                }
            } else if (left > -1) {
                arr[i++] = nums[left--];
            } else {
                arr[i++] = nums[secondP++];
            }
        }
        return arr;
    }

    public static int[] sortedSquaresOuterToInner(int[] nums) {

        int[] arr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length-1; left <= right;i-- ) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arr[i] = nums[left] * nums[left];
                left++;
            } else {
                arr[i] = nums[right] * nums[right];
                right--;
            }
        }

        return arr;

    }

    public static void main(String[] args) {
        int arr[] = sortedSquaresOuterToInner(new int[]{-4,-3,0,1,2});
        System.out.println(Arrays.toString(arr));
    }
}
