package revision.stack;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] = (char) (matrix[i - 1][j] + 1);
                }
            }
        }
        return 0;
    }

    public static int maximalRectangleHistogram(int[] matrix) {
        Stack<Integer> stack = new Stack<>();
        int len = matrix.length;
        int[] spans = new int[len];
        int maxSpan = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && matrix[i] < matrix[stack.peek()]) {
                int val = stack.pop();
                int span = stack.isEmpty() ? i  : i - stack.peek() - 1;
                spans[val] = span * matrix[val];
                maxSpan = Math.max(maxSpan, spans[val]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int val = stack.pop();
            int span = stack.isEmpty() ? len  : len - stack.peek() - 1;
            spans[val] = span * matrix[val];
            maxSpan = Math.max(maxSpan, spans[val]);

        }
        return maxSpan;
    }

}
