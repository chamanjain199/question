package leetcode.top100.liked;

import java.util.Arrays;

public class PlusOne {
    public static  int[] plusOne(int[] digits) {

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry > 0) {
            int[] newDigit = new int[digits.length + 1];
            System.arraycopy(digits,0,newDigit,1,digits.length);
            newDigit[0] = carry;
            return newDigit;
        } else
            return digits;

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(plusOne(new int[]{9,9,8})));

    }
}
