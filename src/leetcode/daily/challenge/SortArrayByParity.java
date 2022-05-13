package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {


        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                index++;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;

            }
        }
        return nums;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 6, 7})));
    }
}
