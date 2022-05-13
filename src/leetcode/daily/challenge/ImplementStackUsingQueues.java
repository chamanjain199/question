package leetcode.daily.challenge;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    LinkedList<Integer> putt = new LinkedList<>();
    LinkedList<Integer> pops = new LinkedList<>();
    int top = 0;

    public MyStack() {

    }

    public void push(int x) {
        putt.add(x);
        top = x;
    }

    public int pop() {
        fillPops();
        int rm = pops.remove();
        if(pops.isEmpty()){
         top=0;
        }else {
            top = pops.peek();
        }
        return rm;
    }

    private void fillPops() {
        if (pops.isEmpty() && !putt.isEmpty()) {
            for (int i = 0; i < 5 && !putt.isEmpty(); i++) {
                pops.add(putt.remove(putt.size() - 1));
            }
        }
    }

    public int top() {

        return top;
    }

    public boolean empty() {
        return pops.isEmpty() && putt.isEmpty();
    }
}

public class ImplementStackUsingQueues {


    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        System.out.println(ms.pop());
        ms.push(2);

        System.out.println(ms.top());
        ms.push(3);
        System.out.println(ms.top());
        System.out.println(ms.empty());

    }
}
