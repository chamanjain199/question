package leetcode.random;

import java.util.Arrays;

public class GCDofTwoNumbers {
    public int findGCD(int[] nums) {
        int num1 = 1000;
        int num2 = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < num1) {
                num1 = nums[i];
            }
            if (nums[i] > num2) {
                num2 = nums[i];
            }
        }
        return gcd(num1, num2);
    }

    public int gcd(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }

    private static int gcd2(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        return num1;
    }


    public static void main(String[] args) {
//        System.out.println(findGCD8(new int[]{5, 10}));
//
//        System.out.println(Arrays.toString(lcmAndGcd(5L, 10L)));

    }
}
