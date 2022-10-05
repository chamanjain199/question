package geeksForGeeks.sorting;

import java.util.Arrays;

public class Merge {
    public static void merge(int low, int mid, int high, int[] arr) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] newMerged = new int[high + 1];
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                newMerged[k++] = arr[i++];
            } else {
                newMerged[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            newMerged[k++] = arr[i++];
        }
        while (j <= high) {
            newMerged[k++] = arr[j++];
        }
        if (high - low >= 0) System.arraycopy(newMerged, low, arr, low, high - low+1);
    }

    public static void main(String[] args) {
        //mid is the separation between two sorted list
        // list before mid must be sorted or after it also must be sorted
        int[] arr = new int[]{4, 5,0, 1, 3, 7, 19, 29};
        merge(0, 1, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));

    }
}
