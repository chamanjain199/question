package self;

import java.util.Arrays;

public class KthSmallestElement {
    public static int kthSmallestLower(int[] arr, int l, int r, int k) {
        if (k < 1) {
            return arr[l - 1];
        }
        for (int i = r; i > l; i--) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

        }
        return kthSmallestLower(arr, l + 1, r, k - 1);
    }

    public static int kthSmallestUpper(int[] arr, int l, int r, int k) {
        if (k < 1) {
            System.out.println(Arrays.toString(arr));
            return arr[l - 1];
        }
        for (int i = r; i > l; i--) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

        }
        return kthSmallestUpper(arr, l + 1, r, k - 1);
    }

    private static int kthSmallest(int[] arr, int l, int r, int k) {
        int i = arr.length / 2;
        if (k < i) {
            return kthSmallestLower(arr, l, r, k);
        } else {
            return kthSmallestUpper(arr, l, r, k);

        }
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 0, 8, 9
        ));
    }


}
