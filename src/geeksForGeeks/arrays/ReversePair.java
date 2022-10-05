package geeksForGeeks.arrays;

import java.util.Arrays;

public class ReversePair {

    public static int reversePairs(int[] nums) {
        int count = mergeSort(0, nums.length - 1, nums);
        return count;
    }

    public static int mergeSort(int start, int end, int[] arr) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;

            count += mergeSort(start, mid, arr);
            count += mergeSort(mid + 1, end, arr);
            count += merge(start, mid, end, arr);
        }
        return count;
    }


    public static int merge(int left, int mid, int right, int[] arr) {
        int lenLeft = mid - left + 1;
        int lenRight = right - mid;
        int count = 0;

        int[] leftArr = new int[lenLeft];
        int[] rightArr = new int[lenRight];


        System.arraycopy(arr, left, leftArr, 0, lenLeft);
        System.arraycopy(arr, mid + 1, rightArr, 0, lenRight);

        int m=0;
        for (int l = 0; l < lenLeft; l++) {
            while (m < lenRight && leftArr[l] >((long)rightArr[m]*2)) m++;
            count+=m;
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < lenLeft && j < lenRight) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < lenLeft) {
            arr[k++] = leftArr[i++];
        }
        while (j < lenRight) {
            arr[k++] = rightArr[j++];
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{2,4,3,5,1
        }));
    }
}
