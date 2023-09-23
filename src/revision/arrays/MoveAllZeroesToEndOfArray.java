package revision.arrays;

import java.util.Arrays;

public class MoveAllZeroesToEndOfArray {
    void pushZerosToEnd(int[] arr, int n) {
        int lastNonZeroElement = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroElement++] = arr[i];
            }
        }
        Arrays.fill(arr, lastNonZeroElement, n, 0);

    }
}
