package geeksForGeeks.sorting;

import java.util.Arrays;

public class CycleSort {
    static void cycleSortDistinct(int arr[], int n) {
        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;
            while (cs != pos) {
                pos = cs;
                for (int i = cs + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                temp = item;
                item = arr[pos];
                arr[pos] = temp;

            }

        }
    }

    public static void main(String[] args) {
        int arr[]=new int[]{9,13,2};
        cycleSortDistinct(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
