package geeksForGeeks.arrays;

import java.util.ArrayList;

public class BuySellStock2 {


    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                ArrayList<Integer> al2 = new ArrayList<>();
                al2.add(i - 1);
                al2.add(i);
                al.add(al2);
            }
        }
        return al;
    }

    static void stockBuySellAnother(int price[], int n) {
        int buyDay = 0;
        boolean foundAnyAns = false;
        int flag = 0;
        int i = 1;
        while (i < n) {
            while (i < n && price[i] >= price[i - 1]) {
                i++;
                flag++;
            }
            while (i < n && price[i] < price[i - 1]) {
                if (flag > 0) {
                    foundAnyAns = true;
                    System.out.print("(" + (buyDay) + " " + (i - 1) + ") ");
                }
                flag = 0;
                buyDay = i;
                i++;
            }

        }
        if (price[buyDay] < price[n - 1]) {
            foundAnyAns = true;
            System.out.print("(" + (buyDay) + " " + (n - 1) + ") ");
        }

        if (!foundAnyAns) {
            System.out.print("No Profit");
        }
        System.out.println();


    }


    public static void main(String[] args) {
        stockBuySellAnother(new int[]{100, 180, 260, 310, 40, 535, 695}, 7);
        // System.out.println(stockBuySell(new int[]{100, 180, 260, 310, 40, 535, 695}, 7));
    }
}
