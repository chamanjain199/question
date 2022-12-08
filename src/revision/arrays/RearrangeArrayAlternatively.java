package revision.arrays;

public class RearrangeArrayAlternatively {
    public static void rearrange(long arr[], int n) {
        long quotient = arr[n - 1] + 1;
        int maxIndex = n - 1;
        int minIndex = 0;
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

    public static void main(String[] args) {

    }

}
