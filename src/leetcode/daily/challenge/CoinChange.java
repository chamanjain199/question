package leetcode.daily.challenge;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[]=new int[amount+1];
        dp[0]=1;
        for (int i = coins.length-1; i >=0; i--) {
            for (int j = coins[i]; j <dp.length ; j++) {

                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount]+1;
    }
    public static void main(String[] args) {
        CoinChange cc=new CoinChange();
        System.out.println(cc.coinChange(new int[]{186,83,408,419},6249));

    }
}
