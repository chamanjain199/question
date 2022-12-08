package geeksForGeeks.stack;

import java.util.LinkedList;


public class StackUsingSingleQueue {
    LinkedList<Integer> q1 = new LinkedList<Integer>();
    Integer top = -1;

    public void push(int x) {
        q1.add(x);
        top = x;
        int sw = q1.size();
        while (sw > 1) {
            q1.add(q1.remove());
            sw--;
        }
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
