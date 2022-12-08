package geeksForGeeks.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    Integer top = -1;

    public StackUsingQueues() {

    }

    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        int re = -1;
        if (!q1.isEmpty()) {
            re = q1.remove();
            Integer peek = q1.peek();
            top = peek == null ? -1 : peek;
        } else {
            top = -1;
        }
        return re;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(2);
        stackUsingQueues.push(3);
        System.out.println(stackUsingQueues.pop());
        stackUsingQueues.push(4);
        System.out.println(stackUsingQueues.pop());
    }
}
