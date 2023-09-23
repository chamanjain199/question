package revision.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] < price[i]) stack.pop();
            if (stack.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 4, 5, 90, 120, 80};
        System.out.println(Arrays.toString(calculateSpan(input, input.length)));
    }
}
