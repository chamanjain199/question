package geeksForGeeks.searching;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length <= nums2.length)
            return median(nums1, nums2);
        else
            return median(nums2, nums1);
    }

    public static double medianOfArrays(int n, int m, int a[], int b[]) {
        return 0l;
    }

    private static double median(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int leftHalfSize = (len1 + len2 + 1) / 2;
        int cut1;
        int cut2;
        int l1 = 0;
        int l2 = 0;
        int r1 = 0;
        int r2 = 0;
        int low = 0;
        int high = len1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            cut1 = mid;
            cut2 = leftHalfSize - mid;
            if (cut1 == 0) {
                l1 = Integer.MIN_VALUE;
            } else {
                l1 = arr1[cut1 - 1];
            }
            if (cut2 == 0) {
                l2 = Integer.MIN_VALUE;
            } else {
                l2 = arr2[cut2 - 1];
            }
            if (cut1 == len1) {
                r1 = Integer.MAX_VALUE;
            } else {
                r1 = arr1[cut1];
            }
            if (cut2 == len2 ) {
                r2 = Integer.MAX_VALUE;
            } else {
                r2 = arr2[cut2];
            }
            if (l1 <= r2 && l2 <= r1) {
                break;
            }
            if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (((len1 + len2) & 1) == 0) {
            int sum = Math.max(l1, l2) + Math.min(r1, r2);
            return (double) sum / 2;
        } else {
            return Math.max(l1, l2);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3,4}, new int[]{2,7}));
    }
}
