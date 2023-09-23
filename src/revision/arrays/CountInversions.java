package revision.arrays;

import geeksForGeeks.sorting.Merge;

import java.util.Arrays;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 11, 10, 9};
        mergeRecursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static long mergeRecursive(int[] arr, int left, int right) {
        long count = 0L;
        if (left < right) {
            int mid = (left + right) >> 1;
            count += mergeRecursive(arr, left, mid);
            count += mergeRecursive(arr, mid + 1, right);
            count += merge(left, mid, right, arr);
        }
        return count;
    }

    private static long merge(int left, int mid, int right, int[] arr) {
        long count = 0L;
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];
        System.arraycopy(arr, left, leftArray, 0, len1);
        System.arraycopy(arr, mid + 1, rightArray, 0, len2);
        int i = 0;
        int j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i++];
            } else {
                arr[k] = rightArray[j++];
                count += len1 - i;
            }
            k++;
        }
        System.arraycopy(leftArray, i, arr, k, len1 - i);
        System.arraycopy(rightArray, j, arr, k, len2 - j);
        return count;
    }
}
