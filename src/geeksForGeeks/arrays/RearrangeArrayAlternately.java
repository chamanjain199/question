package geeksForGeeks.arrays;

import java.util.Arrays;
//Dividend = Divisor x Quotient + Remainder
public class RearrangeArrayAlternately {
    public static void rearrange(long arr[], int n) {
        int maxIndex = n - 1;
        int minIndex = 0;
        long quotient = arr[maxIndex] + 1;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                arr[i] = (arr[maxIndex--] % quotient) * quotient + arr[i];
            } else {
                arr[i] = (arr[minIndex++] % quotient) * quotient + arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= quotient;
        }
    }

    public static void rearrangeNextQuestionSol(long arr[], int n) {
        long quotient = n;
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[(int) arr[i]] % quotient) * quotient + arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= quotient;
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5, 6};
        rearrange(arr, 6);

        System.out.println(Arrays.toString(arr));
       arr = new long[]{1, 2, 3, 4, 5, 6};
        rearrangeNextQuestionSol(arr, 6);
        System.out.println(Arrays.toString(arr));

    }
}
