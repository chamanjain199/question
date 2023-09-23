package geeksForGeeks.stack;

import java.util.Map;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public  static int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;

        Stack<Integer> st = new Stack<>();
        int stTop;
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                stTop = heights[st.pop()];
                res = Math.max(res, stTop * (st.isEmpty() ? i : i - st.peek() - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            stTop = heights[st.pop()];
            res = Math.max(res, stTop * (st.isEmpty() ? len : len - st.peek() - 1));
        }
      
        return res;

    }

    public static void main(String[] args) {
        System.out.println( largestRectangleArea(new int[]{2,3,0,4,2}));
    }
}
