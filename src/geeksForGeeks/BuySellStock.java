package geeksForGeeks;

import java.util.ArrayList;

public class BuySellStock {
    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {

        int buy=Integer.MAX_VALUE;
        int sell=0;
        int buyIndex=0;
        int sellIndex=0;
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int temp=Math.min(buy,A[i]);
            if(temp!=buy){
                if( sellIndex!=0) {
                    ArrayList<Integer> ll = new ArrayList<Integer>();
                    ll.add(buyIndex);
                    ll.add(sellIndex);
                    l.add(ll);
                }
                buy=temp;
                buyIndex=i;
                System.out.println("By index "+buyIndex);

            }

            temp=Math.max(sell,A[i]-buy);
            if(temp!=sell){
                sell=temp;
                sellIndex=i;
                System.out.println("sell index "+sellIndex);

            }

        }
        ArrayList<Integer> ll = new ArrayList<Integer>();
        ll.add(buyIndex);
        ll.add(sellIndex);
        l.add(ll);



        return l;

    }

    public static void main(String[] args) {
       System.out.println(stockBuySell(new int[]{11 ,42, 49, 96, 23, 20 ,49 ,26, 26, 18, 73, 2 ,53, 59, 34, 99, 25, 2}, 7));
    }
}
