package geeksForGeeks.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    Stack<Integer> stackSpan;
    List<Integer> prices;

    public StockSpanProblem() {
        stackSpan = new Stack<>();
        prices = new ArrayList<>();
    }

    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> stackSpan = new Stack<>();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {

            while (!stackSpan.isEmpty() && price[stackSpan.peek()] < price[i]) stackSpan.pop();
            if (stackSpan.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - stackSpan.peek();
            }
            stackSpan.push(i);

        }
        return ans;
    }


    public int next(int price) {
        prices.add(price);
        int i = prices.size();
        while (!stackSpan.isEmpty() && prices.get(stackSpan.peek()) <= price) {
            stackSpan.pop();
        }
        int ans = i;
        if (!stackSpan.isEmpty()) {
            ans = i - stackSpan.peek()-1;
        }
        stackSpan.push(i - 1);
        return ans;
    }

    public static void main(String[] args) {
        StockSpanProblem stockSpanProblem = new StockSpanProblem();
        stockSpanProblem.next(100);
        stockSpanProblem.next(80);
        stockSpanProblem.next(60);
        stockSpanProblem.next(70);
        stockSpanProblem.next(60);
        stockSpanProblem.next(75);
    }
}
