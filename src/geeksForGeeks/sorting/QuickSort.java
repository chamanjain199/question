package geeksForGeeks.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int l, int h) {
        int partitionIndex;
        if (l < h) {
            partitionIndex = lomutoPartition(arr, l, h);
            quickSort(arr, l, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, h);
        }
    }

    public static void quickSort1(int[] arr, int l, int h) {
        int partitionIndex;
        if (l < h) {
            partitionIndex = hoarePartition(arr, l, h);
            quickSort(arr, l, partitionIndex);
            quickSort(arr, partitionIndex + 1, h);
        }
    }

    public static int lomutoPartition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int indexSmallEle = l - 1;
        for (int indexOfLargeElement = l; indexOfLargeElement <= (h - 1); indexOfLargeElement++) {
            if (arr[indexOfLargeElement] < pivot) {
                indexSmallEle++;
                swap(arr, indexSmallEle, indexOfLargeElement);
            }
        }
        indexSmallEle++; // swap with first large element to pivot
        swap(arr, indexSmallEle, h);
        return indexSmallEle;
    }

    public static int hoarePartition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l - 1;
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int partition = hoarePartition(arr, low, high);
            quickSort2(arr, low, partition);
            quickSort2(arr, partition + 1, high);
        }
    }

    public static int hoarePartition2(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }

    }

    public static int lomutoPartition2(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, low);
        return i;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{5, 4, 3, 2, 1};
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
