package geeksForGeeks.arrays;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int firstLowerIndex = nums.length - 2;
        int toReplace = nums.length - 1;

        while (firstLowerIndex >= 0 && nums[firstLowerIndex] >= nums[firstLowerIndex + 1]) firstLowerIndex--;

        if (firstLowerIndex >= 0) {
            while (nums[toReplace] <= nums[firstLowerIndex]) toReplace--;
            swap(firstLowerIndex,toReplace,nums);
        }
        reverse(firstLowerIndex+1,nums.length-1,nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int i, int j, int[] nums) {
        while (i < j) swap(i++, j--, nums);
    }

    public static void main(String[] args) {
        NextPermutation obj=new NextPermutation();
        obj.nextPermutation(new int[]{1,2,3,4,8,9,5,6,4});
        //123456789
        //123  8765

    }
}
