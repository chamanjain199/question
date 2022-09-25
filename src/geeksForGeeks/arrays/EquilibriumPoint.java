package geeksForGeeks.arrays;

public class EquilibriumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        long totalSum = 0;
        for (long num : arr) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == totalSum - arr[i]) {
                return 1;
            }
            leftSum += arr[i];
            totalSum -= arr[i];
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
