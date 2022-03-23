package leetcode.top100.liked;

import java.util.Stack;

class StackNode {
    int val;
    int minValue;

    StackNode(int val, int minValue) {
        this.val = val;
        this.minValue = minValue;
    }
}

class MinStack {

    Stack<StackNode> stack;

    public MinStack() {
        stack= new Stack<>();
    }

    public void push(int val) {

        stack.push(new StackNode(val, Math.min(val, stack.peek().val)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.pop().val;
    }

    public int getMin() {
        return stack.peek().minValue;
    }
}

public class MinStackMain {
    public static void main(String[] args) {

    }
}
