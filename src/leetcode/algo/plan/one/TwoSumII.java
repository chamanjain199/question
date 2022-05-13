package leetcode.algo.plan.one;

import java.util.Arrays;

public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        int[] arr = new int[2];
        arr[0] = left + 1;
        arr[1] = right + 1;
        return arr;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)));
    }
}
