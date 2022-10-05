package geeksForGeeks.sorting;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int gap = len;
        while (gap > 0) {
            gap = gap / 2;
            int index = 0;
            while (index < (len - gap)) {
                if (arr[index] > arr[index + gap]) {
                    swap(arr, index, index + gap);
                    int revIndex = index;
                    while (revIndex - gap >= 0 && arr[revIndex] < arr[revIndex - gap]) {
                        swap(arr, revIndex, revIndex - gap);
                        revIndex--;

                    }

                }
                index++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,1,1,1,4};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
