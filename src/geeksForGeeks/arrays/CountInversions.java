package geeksForGeeks.arrays;

import geeksForGeeks.sorting.Merge;

import java.util.Arrays;

public class CountInversions {
    static long inversionCount(long arr[], long N) {
        return mergeSortRecursive(arr, 0, N);
    }

    public static long mergeSortRecursive(long[] arr, long low, long high) {
        long count = 0;
        if (low < high) {
            long mid = (low + high) / 2;
            count += mergeSortRecursive(arr, low, mid);
            count += mergeSortRecursive(arr, mid + 1, high);
            count += merge(low, mid, high, arr);
        }
        return count;
    }

    public static long merge(long low, long mid, long high, long[] arr) {
        int i = (int) low;
        int j = (int) (mid + 1);
        int k = (int) low;
        long count = 0;
        long[] newMerged = new long[(int) (high + 1)];

        System.arraycopy(newMerged, (int) low, arr, (int) low, (int) (high - low + 1));
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                newMerged[k++] = arr[i++];
            } else {
                count += mid - i + 1;
                newMerged[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            newMerged[k++] = arr[i++];
        }
        while (j <= high) {
            newMerged[k++] = arr[j++];
        }
        if (high - low >= 0) System.arraycopy(newMerged, (int)low, arr, (int)low, (int)(high - low+1));

        return count;
    }


    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }
}
