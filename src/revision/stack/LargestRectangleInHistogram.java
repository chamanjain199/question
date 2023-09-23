package revision.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static long getMaxArea(long hist[], long n) {
        int len = (int) n;
        int[] leftSmaller = new int[len];
        int[] rightSmaller = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();
            leftSmaller[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();
            rightSmaller[i] = stack.isEmpty() ? len - 1 : stack.peek() - 1;
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, (rightSmaller[i] - leftSmaller[i] + 1) * hist[i]);
        }

        return ans;
    }

    public static long getMaxArea1(long hist[], long n) {
        Stack<Integer> stack = new Stack<>();
        int len=(int)n;
        long[] spans = new long[len];
        long maxSpan = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && hist[i] < hist[stack.peek()]) {
                long val = stack.pop();
                long span = stack.isEmpty() ? i  : i - stack.peek() - 1;
                spans[(int)val] = span * hist[(int)val];
                maxSpan = Math.max(maxSpan, spans[(int)val]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            long val = stack.pop();
            long span = stack.isEmpty() ? n  : n - stack.peek() - 1;
            spans[(int)val] = span * hist[(int)val];
            maxSpan = Math.max(maxSpan, spans[(int)val]);

        }
        return maxSpan;
    }

    static int largestRectangleArea(int histo[]) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    public static void main(String[] args) {
        long[] input = {2, 1, 5, 6, 2, 3, 1};
        System.out.println(getMaxArea1(input, input.length));
    }
}
