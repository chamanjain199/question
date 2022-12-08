package geeksForGeeks.queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.add(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if (!s1.isEmpty()) {
            return s1.pop();
        }
        return -1;
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
    public static void main(String[] args) {
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        queueUsingTwoStacks.push(1);
        queueUsingTwoStacks.push(2);
        queueUsingTwoStacks.push(3);
        queueUsingTwoStacks.push(4);
        System.out.println(queueUsingTwoStacks.pop());
    }
}
