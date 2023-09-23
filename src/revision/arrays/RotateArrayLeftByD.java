package revision.arrays;

import java.util.Arrays;

public class RotateArrayLeftByD {
    public void rotate(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int len = nums.length-1;
        int d = k % len;
        rotateUtil(nums, 0, len);
        System.out.println(Arrays.toString(nums));
        rotateUtil(nums, 0, len-d);
        System.out.println(Arrays.toString(nums));

        rotateUtil(nums, len-d+1 , len);
        System.out.println(Arrays.toString(nums));
    }

    public void rotateUtil(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }

    public void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        RotateArrayLeftByD obj=new RotateArrayLeftByD();
        obj.rotate(new int[]{1,2,3,4,5},3);

    }
}
