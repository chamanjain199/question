package geeksForGeeks.arrays;

import java.util.ArrayList;

public class BuySellStock3 {
    static int stockBuySell(int A[], int n) {
        int maxProfit = Integer.MIN_VALUE;
        int buyPrice = A[0];

        for (int i = 0; i < n; i++) {
             maxProfit = Math.max(A[i] - buyPrice, maxProfit);
             buyPrice = Math.min(buyPrice, A[i]);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(stockBuySell(new int[]{10, 22, 5, 75, 65, 80},6));
    }
}
