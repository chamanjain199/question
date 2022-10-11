package geeksForGeeks.searching;

import java.util.Arrays;

public class AggressiveCows {
    public static int solve(int n, int k, int[] v) {
        Arrays.sort(v);
        int low = 1;
        int high = v[n - 1] - v[0];
        int mid;

        while (low <= high) {
            mid = (low + high) >> 1;
            if (canPlaceAllCowWithMinimun(v, mid, k)) {

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean canPlaceAllCowWithMinimun(int[] v, int dist, int k) {
        int count = 1;
        int coordinate = v[0];
        for (int i = 1; i < v.length; i++) {
            if ((v[i] - coordinate) >= dist) {
                coordinate = v[i];
                count++;
            }
        }
        return count >= k;
    }


    public static void main(String[] args) {
        System.out.println(solve(5, 2, new int[]{1, 2, 4, 8, 9}));
    }
}
