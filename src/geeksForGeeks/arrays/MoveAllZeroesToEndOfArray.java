package geeksForGeeks.arrays;

import java.util.Arrays;

public class MoveAllZeroesToEndOfArray {
    static void pushZerosToEnd(int[] arr, int n) {
        int indexToNonZero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[indexToNonZero++] = arr[i];
            }
        }
        for (int i = indexToNonZero; i < n; i++) {
            arr[i] = 0;
        }
    }
    static void pushZerosToEnd2(int[] arr, int n) {
        int indexToNonZero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp=arr[i];
                arr[i]= arr[indexToNonZero];
                arr[indexToNonZero++] =temp;
            }
        }
//        for (int i = indexToNonZero; i < n; i++) {
//            arr[i] = 0;
//        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0,4};
        pushZerosToEnd2(arr,4);
        System.out.println(Arrays.toString(arr));
    }
}
