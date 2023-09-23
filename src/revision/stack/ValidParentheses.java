package revision.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] parentheses = s.toCharArray();
        for (char c : parentheses) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if ((last == '{' && c != '}') || (last == '(' && c != ')') || (last == '[' && c != ']')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
