package test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;

public class MyThread {
    static long[] dp;
    static long mod = 1000000007;
    static int MAX = 100000000;
    static int[] coins=new int[]{  2000,500,200,100,50,20,10,5,2,1 };
    static List<Integer> minPartition(int N)
    {
        List<Integer> ans=new ArrayList<Integer>();
        for(int coin : coins){
            if(coin<=N){
                int t=N/coin;
                N=N%coin;
                for(int i=0;i<t;i++){
                    ans.add(coin);
                }
            }
        }
        return ans;
    }
    static long bottomUp(int n) {
        dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n ] % mod;

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(minPartition(43));
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Child method");
//            }
//        });
//        t1.start();
//        t1.join();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Main method");
//        }


    }
}
