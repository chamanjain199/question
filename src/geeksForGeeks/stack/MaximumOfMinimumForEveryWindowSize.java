package geeksForGeeks.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumOfMinimumForEveryWindowSize {
    static int[] maxOfMin(int[] arr, int n) {
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int pop = arr[stack.pop()];
                int span = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans[span - 1] = Math.max(ans[span - 1], pop);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pop = arr[stack.pop()];
            int span = stack.isEmpty() ? n : n - stack.peek() - 1;
            ans[span - 1] = Math.max(ans[span - 1], pop);
        }
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = new int[]{100, 20, 10, 50, 10, 70, 30};
        System.out.println(Arrays.toString(maxOfMin(arr, arr.length)));
    }
}

