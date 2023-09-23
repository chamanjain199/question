package revision.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 2;
        int lastIndex = len - 1;
        while (index >= 0 && nums[index] >= nums[index + 1]) index--;

        if (index >= 0) {
            while (nums[lastIndex] <= nums[index]) lastIndex--;
            swap(index, lastIndex, nums);
        }
        reverse(index + 1, len - 1, nums);

    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int i, int j, int[] nums) {
        while (i < j) swap(i++, j--, nums);
    }

    public static void main(String[] args) {

    }
}
