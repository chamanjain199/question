package self;

import java.util.Arrays;

public class MergeTwoSortedArray {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] rs = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int rsCounter = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                rs[rsCounter++] = nums1[index1++];
            } else {
                rs[rsCounter++] = nums2[index2++];
            }
        }
        while (index1 < m) {
            rs[rsCounter++] = nums1[index1++];
        }
        while (index2 < n) {
            rs[rsCounter++] = nums2[index2++];
        }
        System.arraycopy(rs, 0, nums1, 0, rsCounter);


    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        //sorted in non-decreasing order, and two integer m and n, representing number of elements in nums1 and nums2
        //The final sorted array should be stored inside the array nums1.

        //I can either add the remainder of nums2 to nums1 and sort
        //Or I can create a copy of nums1 and walk pointers to the end of sorted array.
        //I could start placing numbers that are the maximum? !!!

        //people solve this without these ints?
        int maxOne = m - 1;
        int maxTwo = n - 1;

        for (int i = (m + n - 1); i >= 0; i--) { //start by looking at the last index.
            if (maxOne >= 0 && maxTwo >= 0) {
                if (nums1[maxOne] > nums2[maxTwo]) {
                    nums1[i] = nums1[maxOne];
                    maxOne--;
                } else {
                    nums1[i] = nums2[maxTwo];
                    maxTwo--;
                }
            } else if (maxOne >= 0) {
                nums1[i] = nums1[maxOne];
                maxOne--;
            } else {
                nums1[i] = nums2[maxTwo];
                maxTwo--;
            }
        }

        //return nums1;
    }

    public static void main(String[] args) {

        int arr1[] = new int[]{4, 0, 0, 0, 0, 0};
        int arr2[] = new int[]{1, 2, 3, 5, 6};
        merge(arr1, 1, arr2, 5);
        System.out.println(Arrays.toString(arr1));

    }
}
