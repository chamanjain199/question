package revision.arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] <= buy) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit,  prices[i]-buy);
            }
        }
        return maxProfit;
    }


}
