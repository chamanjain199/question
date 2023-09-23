package revision.arrays;

import java.util.Arrays;

public class RearrangeArrayAlternatively {
    public static void rearrangeSimple(long arr[], int n) {

        long[] temp = new long[n];
        int i = 0;
        int j = n - 1;
        int k = 0;
        while (i <= j) {
            temp[k] = (k & 1) != 0 ? arr[i++] : arr[j--];
            k++;
        }
        System.arraycopy(temp, 0, arr, 0, n);

    }

    public static void rearrange(long arr[], int n) {

        int min_index = 0;
        int max_index = n - 1;
        long quotient = arr[n - 1] + 1; //array is sorted take be needs a bigger number then largest number in array
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                arr[i] = (arr[max_index--] % quotient) * quotient + arr[i];
            } else {
                arr[i] = (arr[min_index++] % quotient) * quotient + arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= quotient;
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6};
        rearrange(arr, 6);
        System.out.println(Arrays.toString(arr));
    }

}
