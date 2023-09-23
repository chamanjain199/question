package geeksForGeeks.stack;

import java.util.Stack;

public class  InfixToPostfix {
    public static String infixToPostfix(String exp) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            char[] chars = exp.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                char c = chars[i];
                if (c == '(') {
                    stack.push(c);
                } else if (c == '+' || c == '-') {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^')) {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);

                } else if (c == '*' || c == '/') {
                    if (!stack.isEmpty()  && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '^')) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                } else if (c == '^') {
                    if (!stack.isEmpty() && stack.peek() == '^') {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if (!stack.isEmpty()) stack.pop();
                }else{
                    sb.append(c);
                }
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();

    }

    public static void main(String[] args) {
        //
        //abcd^e-fgh*+^i
        //"A*(B+C)/D" ans ABC+*D/
        // "a+b*(c^d-e)^(f+g*h)-i" ans == abcd^e-fgh*+^*+i-
        System.out.println(infixToPostfix("a+b/c+d"));
    }
}
