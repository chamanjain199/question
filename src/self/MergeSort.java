package self;

import java.util.Arrays;

public class MergeSort {


    private static void mergeSort(int arr[], int l, int r) {
        if (l != r) {

            int m = (r + l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);

        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int s1 = 1+m - l;
        int s2 = r - m;

        int leftArray[] = new int[s1];
        int rightArray[] = new int[s2];

        System.arraycopy(arr, l, leftArray, 0, s1);
        System.arraycopy(arr, m + 1, rightArray, 0, s2);
        int count = l;
        int c1 = 0;
        int c2 = 0;
        while (c1 < s1 && c2 < s2) {
            if (leftArray[c1] <= rightArray[c2]) {
                arr[count++] = leftArray[c1++];
            } else {
                arr[count++] = rightArray[c2++];
            }
        }
        while (c1 < s1) {
            arr[count++] = leftArray[c1++];
        }
        while (c2 < s2) {
            arr[count++] = rightArray[c2++];
        }

    }

    public static void main(String[] args) {
        int arr[]=new  int[]{9,8,7,6,5,4,3,2,1,0};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

}
