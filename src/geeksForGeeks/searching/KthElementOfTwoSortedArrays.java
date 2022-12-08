package geeksForGeeks.searching;

public class KthElementOfTwoSortedArrays {
    public static long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (n <= m) {
            return kthElementBinarySearch(arr1, arr2, n, m, k);
        } else {
            return kthElementBinarySearch(arr2, arr1, m, n, k);
        }
    }

    public static long kthElementBinarySearch(int arr1[], int arr2[], int n, int m, int k) {
        int cut1;
        int cut2;
        int l1;
        int l2;
        int r1;
        int r2;
        int low = Math.max(0, k-m);
        int high = Math.min(k, n);
        while (low <= high) {
            cut1 = (low + high) >> 1;
            cut2 = k - cut1;

            l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 =new int[]{2,5};
        int[] arr2 =new int[]{3,4};
        System.out.println(kthElement(arr1,arr2,arr1.length,arr2.length,2));
    }
}
