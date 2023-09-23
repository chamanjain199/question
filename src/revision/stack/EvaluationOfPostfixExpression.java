package revision.stack;

import java.util.Stack;

public class EvaluationOfPostfixExpression {
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S) {
        Stack<Integer> stack = new Stack<>();
        int num1;
        int num2;
        char ch;
        int len = S.length();
        for (int i = 0; i < len; i++) {
             ch = S.charAt(i);
            if (ch == '+') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (ch == '-') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (ch == '*') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (ch == '/') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else if (ch == '^') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push((int) Math.pow(num2, num1));
            } else {
                stack.push(ch - '0');
            }
        }
        return stack.peek();
    }
}
