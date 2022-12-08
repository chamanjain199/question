package geeksForGeeks.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //////////////////Solution 2 :: good one
    public static void insertionSort2(int[] arr) {
        int len = arr.length;
        for (int k = 1; k < len; k++) {
            int j = k - 1;
            int x = arr[k];
            while (j > -1 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = x;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
