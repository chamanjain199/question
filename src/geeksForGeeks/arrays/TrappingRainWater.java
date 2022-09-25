package geeksForGeeks.arrays;

public class TrappingRainWater {
    static long trappingWater(int arr[], int n) {
        long totalWater = 0;
        for (int i = 1; i < n - 1; i++) {
            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            int rmax = arr[i];
            for (int j = i + 1; j < n; j++) {
                rmax = Math.max(rmax, arr[j]);
            }
            totalWater += (Math.min(lmax, rmax) - arr[i]);

        }
        return totalWater;
    }

    static long trappingWater2(int arr[], int n) {
        long totalWater = 0;
        int[] lmax = new int[n];
        lmax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(arr[i], lmax[i - 1]);
        }
        int[] rmax = new int[n];
        rmax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(arr[i], rmax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            totalWater += (Math.min(lmax[i], rmax[i]) - arr[i]);
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        trappingWater2(arr, arr.length);
        System.out.println();
    }
}
