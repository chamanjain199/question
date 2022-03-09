package leetcode.top100.liked;

public class BestBuyAndSell {
    public static int maxProfitWorst(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {

            for (int j = i; j < prices.length; j++) {
                int t = prices[j] - prices[i];
                if (t > profit) {
                    profit = t;
                }
            }
        }
        return profit;
    }
    public static int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int sell=0;
        for (int i = 0; i < prices.length; i++) {

            buy=Math.min(buy,prices[i]);
            System.out.println("buy "+buy);

            sell=Math.max(sell,prices[i]-buy);
            System.out.println("sell "+sell);

        }
        return sell;
    }

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{0,0,800,-900,700}));
    }
}
