package leetcode.top100.liked;


import java.util.Arrays;

public class MedianOfTwoSortedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int length = (totalLength / 2) + 1;
        int tempArray[] = new int[length];

        int nums1Index = 0;
        int nums2Index = 0;
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        for (int i = 0; i < length; i++) {

            if (nums1Index < nums1Length && (nums2Index >= nums2Length || nums1[nums1Index] <= nums2[nums2Index])) {
                tempArray[i] = nums1[nums1Index];
                nums1Index++;
            } else if (nums2Index < nums2Length && (nums1Index >= nums1Length || nums2[nums2Index] <= nums1[nums1Index])) {
                tempArray[i] = nums2[nums2Index];
                nums2Index++;
            }
        }
        System.out.println(Arrays.toString(tempArray));
        if (totalLength % 2 == 0) {
            double output = tempArray[length - 1] + tempArray[length - 2];
            output = output / 2;
            return output;
        } else {
            return tempArray[length - 1];
        }

    }

    public static void main(String[] args) {

        int arr1[] = new int[]{2,2,4,4};
        int arr2[] = new int[]{2,2,4,4};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
