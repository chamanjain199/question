package geeksForGeeks.arrays;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {

        int low = 0;
        int high = nums.length;
        int mid = 0;
        while ( mid<high) {
            switch (nums[mid]) {
                case 0 -> {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> swap(nums, mid, --high);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int arr[]=new int[]{1,0};
        System.out.println(Arrays.toString(arr));
        sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }
}
