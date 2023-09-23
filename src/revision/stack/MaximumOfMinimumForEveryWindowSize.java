package revision.stack;

import java.util.Map;
import java.util.Stack;

public class MaximumOfMinimumForEveryWindowSize {
    static int[] maxOfMin(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int val = arr[stack.pop()];
                int span = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans[span-1] = Math.max(ans[span-1], val);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int val = arr[stack.pop()];
            int span = stack.isEmpty() ? n : n - stack.peek() - 1;
            ans[span - 1] = Math.max(ans[span - 1], val);
        }
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;
    }
}
