package geeksForGeeks.stack;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class EvaluationOfPostfixExpression {
    public static int evaluatePostFix(String S) {
        Stack<Integer> stack = new Stack<>();
        int len = S.length();
        char ch;
        int num1;
        int num2;
        for (int i = 0; i < len; i++) {
            ch = S.charAt(i);
            if (ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
            } else if (ch == '^') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push((int) Math.pow(num2, num1));
            } else if (ch == '+') {
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
            }
        }
        return stack.pop();
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int num1;
        int num2;
        for (String ch : tokens) {

            if (Objects.equals(ch, "^")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push((int) Math.pow(num2, num1));
            } else if (Objects.equals(ch, "+")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (Objects.equals(ch, "-")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (Objects.equals(ch, "*")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (Objects.equals(ch, "/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.valueOf(ch));
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFix("231*+9-"));
    }
}
