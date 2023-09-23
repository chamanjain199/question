package geeksForGeeks.arrays;

import java.util.Arrays;

public class MaximumIndex {
    static int maxIndexDiff(int A[], int N) {

        int[] lmin = new int[N];
        int[] Rmax = new int[N];
        lmin[0] = A[0];
        Rmax[N - 1] = A[N - 1];
        for (int i = 1; i < N; i++) {
            lmin[i] = Math.min(lmin[i - 1], A[i]);
            Rmax[N - i - 1] = Math.max(Rmax[N - i], A[N-i-1]);
        }
        int maxDis = -1;
        int i = 0;
        int j = 0;
        while (i < N && j < N) {
            if (lmin[i] <= Rmax[j]) {
                maxDis = Math.max(maxDis, j - i);
                j++;
            } else {
                i++;
            }

        }
        return maxDis;


    }

    public static void main(String[] args) {

        System.out.println(maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1},9));

    }
}
