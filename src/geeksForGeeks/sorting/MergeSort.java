package geeksForGeeks.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSortIterative(int[] arr) {
        int pass;
        int len = arr.length;
        for (pass = 2; pass <= len; pass *= 2) {
            for (int i = 0; i + pass - 1 < len; i += pass) {
                int high = i + pass - 1;
                Merge.merge(i, (i + high) / 2, high, arr);
            }
        }
        if (pass / 2 < len) {
            Merge.merge(0, pass / 2 - 1, len - 1, arr);
        }
    }

    public static void mergeSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortRecursive(arr, low, mid);
            mergeSortRecursive(arr, mid + 1, high);
            Merge.merge(low, mid, high, arr);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 4, 8, 1, 12, 17, 13, 2, 7, 18, 11};
        //mergeSortIterative(arr);
        mergeSortRecursive(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
