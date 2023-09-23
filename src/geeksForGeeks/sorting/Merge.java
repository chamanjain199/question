package geeksForGeeks.sorting;

import java.util.Arrays;

public class Merge {
    public static void merge(int low, int mid, int high, int[] arr) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] newMerged = new int[high + 1]; // not a good method suppose you low is 400 and high is 500 then you will be creating
                                             // a new array of size 501 that is not required
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
        if (high - low >= 0) System.arraycopy(newMerged, low, arr, low, high - low + 1);
    }

    public static void merge2(int low, int mid, int high, int[] arr) {
        int len1 = mid - low + 1; //mid consider part of first array [1,2,3] low =0 mid 1 high 2 [1,2],[3]
        int len2 = high - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        System.arraycopy(arr, low, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);
        int i = 0;
        int j = 0;
        int k = low;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < len1) {
            arr[k++] = leftArr[i++];
        }
        while (j < len2) {
            arr[k++] = rightArr[j++];
        }

    }
    private static long mergeRecursive(int[] arr, int left, int right) {
        long count = 0L;
        if (left < right) {
            int mid = (left + right) >> 1;
            count += mergeRecursive(arr, left, mid);
            count += mergeRecursive(arr, mid + 1, right);
            count += merge4(left, mid, right, arr);
        }
        return count;
    }

    private static long merge4(int left, int mid, int right, int[] arr) {
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

    public static void main(String[] args) {
        //mid is the separation between two sorted list
        // list before mid must be sorted or after it also must be sorted
        int[] arr = new int[]{0,0,0,4, 5, 0, 1, 3, 7, 19, 29};
        merge2(0, 1, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{0,0,0,0,4,0,8,1,2};
        merge2(0, 1, arr2.length - 1, arr2);
        System.out.println(Arrays.toString(arr2));

    }
}
