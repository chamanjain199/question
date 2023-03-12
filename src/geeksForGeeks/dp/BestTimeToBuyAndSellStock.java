package geeksForGeeks.dp;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] <= buyPrice) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] = buyPrice);
            }
        }
        return profit;
    }
}
