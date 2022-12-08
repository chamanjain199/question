package geeksForGeeks.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int res = 0;
        int len1 = matrix.length;
        for (int i = 1; i < len1; i++) {
            int len2 = matrix[i].length;
            for (int j = 0; j < len2; j++) {
                if (matrix[i][j] != '0' && matrix[i - 1][j] != '0') {
                    matrix[i][j] = (char) (((int) matrix[i - 1][j]) + 1);
                }
            }
        }
        for (char[] chars : matrix) {
            res = Math.max(maximalRectangle(chars), res);
        }
        return res;
    }

    public static int maximalRectangle(char[] arr) {
        int res = 0;
        int len1 = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ch;
        for (int i = 0; i < len1; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                ch = arr[stack.pop()] - '0';
                res = Math.max(res, ch * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ch = arr[stack.pop()] - '0';
            res = Math.max(res, ch * (stack.isEmpty() ? len1 : len1 - stack.peek() - 1));
        }
        return res;
    }

    public int maxArea(int M[][], int n, int m) {
        int res = 0;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (M[i][j] != 0 && M[i - 1][j] != 0) {
                    M[i][j] = M[i - 1][j] + 1;
                }
            }
        }
        for (int[] subArr : M) {
            res = Math.max(largestRectangleArea(subArr), res);
        }
        return res;
    }

    public static int largestRectangleArea(int[] heights) {
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
        char[][] chars = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}};
        System.out.println(maximalRectangle(chars));

    }
}
