package geeksForGeeks.arrays;

import java.util.Arrays;

public class BuySellStock4 {

    static int maxProfitNotworking(int K, int N, int A[]) {
        String s=new String();
        s.indexOf("AA");
        int[] lmax = new int[N];
        int[] lmin = new int[N];
        lmin[0] = A[0];
        lmax[0] = A[0];
        int[] allProfits = new int[N];

        for (int i = 1; i < N; i++) {
            if (A[i] > A[i - 1])
                allProfits[i] = A[i] - A[i - 1];

        }
        Arrays.sort(allProfits);
        System.out.println(Arrays.toString(allProfits));

        int maxProfit = 0;
        for (int i = N - 1; i >= N - K; i--) {
            maxProfit += allProfits[i];
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfitNotworking(2,6 ,new int[]{10, 22, 5, 75, 65, 80}));

       // System.out.println(maxProfit(7, 25, new int[]{604, 902, 153, 292, 382, 421, 716, 718, 895, 447, 726, 771, 538, 869, 912, 667, 299, 35, 894, 703, 811, 322, 333, 673, 664}));

    }
}
