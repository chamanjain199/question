package revision.stack;

import java.util.Stack;

public class SortAStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        int len = s.size();
        for (int i = 0; i <len; i++) {
            sortStack(s);
        }
        return s;
    }

    public static void sortStack(Stack<Integer> s) {
        if (s.isEmpty() || s.size() == 1) {
            return;
        }
        Integer num1 = s.pop();
        Integer num2 = s.pop();
        if (num1 > num2) {
            s.push(num1);
        } else {
            s.push(num2);
        }
        sortStack(s);
        if (num1 > num2) {
            s.push(num2);
        } else {
            s.push(num1);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(11);
        stack.add(2);
        stack.add(32);
        stack.add(3);
        stack.add(41);
        System.out.println(stack);
        System.out.println(sort(stack));
    }
}
