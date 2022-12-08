package geeksForGeeks.stack;


class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

public class MyStack2 {

    StackNode top;

    void push(int a) {
        StackNode newNode = new StackNode(a);
        if (top != null) {
            newNode.next = top;
            top = newNode;
        } else {
            top = newNode;
        }
    }

    //Function to remove an item from top of the stack.
    int pop() {
        if (top != null) {
            StackNode tail = top;
            top = top.next;
            return tail.data;
        }
        return -1;
    }


}