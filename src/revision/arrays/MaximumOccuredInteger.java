package revision.arrays;

import java.util.Arrays;

public class MaximumOccuredInteger {
    public static int maxOccured(int L[], int R[], int n, int maxx) {
        int[] maxxArr = new int[maxx + 2];
        for (int i = 0; i < n; i++) {
            maxxArr[L[i]]++;
            maxxArr[R[i] + 1]--;
        }
        int maxElementOccured = maxxArr[0];
        int ans = 0;
        System.out.println(Arrays.toString(maxxArr));
        System.out.println(Arrays.toString(maxxArr));
        for (int i = 1; i < maxx + 2; i++) {
            maxxArr[i] += maxxArr[i - 1];
            if (maxElementOccured < maxxArr[i]) {
                maxElementOccured = maxxArr[i];
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] L = new int[]{1, 4, 3, 1};
        int[] R = new int[]{15, 8, 5, 4};
        System.out.println(maxOccured(L, R, 4, 15));
    }
}
