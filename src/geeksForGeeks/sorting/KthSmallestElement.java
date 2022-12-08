package geeksForGeeks.sorting;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        int partition;
        if (l < r) {
            partition = lomutoPartition(arr, l, r);
            if (partition == (k - 1)) {
                return arr[partition];
            } else if (partition > (k - 1)) {
                return kthSmallest(arr, l, partition - 1, k);
            } else {
                return kthSmallest(arr, partition + 1, r, k);
            }
        }
        return arr[k - 1];
    }


    public static int findKthLargest(int[] nums, int k) {
        return kthSmallest(nums, 0, nums.length, nums.length - k);
    }

    public static int lomutoPartition(int[] arr, int l, int h) {
        int i = l - 1;
        int pivot = arr[h];

        for (int j = l; j <= (h - 1); j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, h);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 5, 787, 1, 23};
        System.out.println(kthSmallest(arr, 0, arr.length - 1, 2));

    }
}
