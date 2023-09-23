package geeksForGeeks.stack;

import java.util.Stack;

public class SortAStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> sorted = new Stack<>();
        while (!s.isEmpty()) {
            int ele = s.pop();
            if (sorted.isEmpty() || ele > sorted.peek()) {
                sorted.push(ele);
            } else {
                while (!sorted.isEmpty() && ele< sorted.peek()) {
                    s.push(sorted.pop());
                }
                sorted.push(ele);
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Stack<Integer> so=sort(stack);
        System.out.println(so);


    }
}
