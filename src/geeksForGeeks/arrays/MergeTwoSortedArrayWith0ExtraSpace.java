package geeksForGeeks.arrays;

import java.util.Arrays;

public class MergeTwoSortedArrayWith0ExtraSpace {
    public static void merge(long[] arr1, long[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int totalLen = len1 + len2;
        int gap = totalLen;
        while (gap > 0) {
            gap = gap / 2;
            int index = 0;
            while (index < (totalLen - gap)) {

                if ((index + gap) < len1) {
                    if (arr1[index] > arr1[index + gap]) {
                        swap(arr1, index, index + gap);
                        int revIndex = index;
                        while (revIndex - gap >= 0 && arr1[revIndex] < arr1[revIndex - gap]) {
                            swap(arr1, revIndex, revIndex - gap);
                            revIndex--;
                        }
                    }
                } else if (index >= len1) {
                    int nextArrIndex = index - len1;
                    if (nextArrIndex + gap < len2 && arr2[nextArrIndex] > arr2[nextArrIndex + gap]) {
                        swap(arr2, nextArrIndex, nextArrIndex + gap);
                        int revIndex = nextArrIndex;
                        while (revIndex - gap >= 0 && arr2[revIndex] < arr2[revIndex - gap]) {
                            swap(arr2, revIndex, revIndex - gap);
                            revIndex--;
                        }
                    }
                } else  {
                    int nextArrIndex = index - len1;
                    if ((nextArrIndex + gap) < len2 && arr1[index] > arr2[nextArrIndex + gap]) {
                        long temp = arr1[index];
                        arr1[index] = arr2[nextArrIndex + gap];
                        arr2[nextArrIndex + gap] = temp;
                        int revIndex = index;
                        while (revIndex - gap >= 0 && arr1[revIndex] < arr1[revIndex - gap]) {
                            swap(arr1, revIndex, revIndex - gap);
                            revIndex--;
                        }
                    }
                }
                index++;
            }
        }
    }


    private static void swap(long[] nums, int i, int j) {
        long temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        long[] arr1 = new long[]{1, 3, 5, 7};
        long[] arr2 = new long[]{0, 2};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        merge(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
