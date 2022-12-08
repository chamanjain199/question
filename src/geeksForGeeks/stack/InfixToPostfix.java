package geeksForGeeks.stack;

import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String exp) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int len = exp.length();
        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == '+' || ch == '-') {
                if (!stack.isEmpty() && stack.peek() != '(') {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^')) {
                        stringBuilder.append(stack.pop());
                    }
                    if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                        stringBuilder.append(stack.pop());
                    }
                }
                stack.push(ch);
            } else if (ch == '*' || ch == '/') {
                if (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^') {
                        stringBuilder.append(stack.pop());
                    }
                }
                stack.push(ch);
            } else if (ch == '^') {
                if (!stack.isEmpty() && stack.peek() == '^') {
                    stringBuilder.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stringBuilder.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                stringBuilder.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        //
        //abcd^e-fgh*+^i
        //"A*(B+C)/D" ans ABC+*D/
        // "a+b*(c^d-e)^(f+g*h)-i" ans == abcd^e-fgh*+^*+i-
        System.out.println(infixToPostfix("a+b/c+d"));
    }
}
