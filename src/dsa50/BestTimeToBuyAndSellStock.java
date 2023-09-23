package dsa50;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //Dont try to think to get ans directly , you can get ans by getting some value and try to maximize or minimized it as you process more input
        int buyPrice = prices[0];
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }
        return maxProfit;
    }
}
