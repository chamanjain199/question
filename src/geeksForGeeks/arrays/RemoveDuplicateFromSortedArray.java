package geeksForGeeks.arrays;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public void removeDuplicateFromSortedArray(int[] arr) {
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[prev] != arr[i]) {
                arr[++prev] = arr[i];
            }
        }
    }

    public static int removeDuplicateFromSortedArray2(int[] arr) {
        int prev = 0;
        boolean sameAsLastElement = true;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[prev] != arr[i]) {
                arr[++prev] = arr[i];
                sameAsLastElement = true;
                count++;
            } else if (arr[prev] == arr[i] && sameAsLastElement) {
                sameAsLastElement = false;
                arr[++prev] = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        removeDuplicateFromSortedArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
