package revision.arrays;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    //Function to merge the arrays.
    public static void mergeTLE(long arr1[], long arr2[], int n, int m) {
        int total = n + m;
        int gap = total;
        while (gap > 0) {
            gap = gap / 2;
            int index = 0;
            int secondIndex = gap;
            while (gap > 0 && secondIndex < total) {
                long ele1 = getEle(arr1, arr2, n, index);
                long ele2 = getEle(arr1, arr2, n, secondIndex);
                if (ele1 > ele2) {
                    swap(arr1, arr2, index, secondIndex, n, ele1, ele2);
                }
                int revIndex = index;
                while (gap > 0 && revIndex - gap >= 0) {
                    ele1 = getEle(arr1, arr2, n, revIndex - gap);
                    ele2 = getEle(arr1, arr2, n, revIndex);
                    if (ele1 > ele2) {
                        swap(arr1, arr2, revIndex - gap, revIndex, n, ele1, ele2);
                    }
                    revIndex--;
                }
                index++;
                secondIndex++;
            }
        }
    }

    private static long getEle(long[] arr1, long[] arr2, int n, int index) {
        if (index >= n) {
            return arr2[index - n];
        } else {
            return arr1[index];
        }
    }

    private static void swap(long[] arr1, long[] arr2, int index, int secondIndex, int n, long ele1, long ele2) {
        if (index >= n) {
            arr2[index - n] = ele2;
        } else {
            arr1[index] = ele2;
        }
        if (secondIndex >= n) {
            arr2[secondIndex - n] = ele1;
        } else {
            arr1[secondIndex] = ele1;
        }
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i=n-1,j=0; long temp=0;
        while(i>=0 && j<m && arr1[i]>arr2[j]){
            temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        long[] arr1 = new long[]{7, 7, 4};
        long[] arr2 = new long[]{5, 7, 9, 15};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
