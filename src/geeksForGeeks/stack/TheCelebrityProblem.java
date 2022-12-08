package geeksForGeeks.stack;

import java.util.Stack;

public class TheCelebrityProblem {
    int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        int num1;
        int num2;
        while (stack.size() >= 2) {
            num1 = stack.pop();
            num2 = stack.pop();
            if (M[num1][num2] == 1) {
                stack.push(num2);
            } else {
                stack.push(num1);
            }
        }
        int pot = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != pot) {
                if (M[i][pot] == 0 || M[pot][i] == 1) {
                    return 0;
                }
            }

        }
        return 1;
    }
}
