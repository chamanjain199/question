package geeksForGeeks.queue;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int a) {
        data = a;
        next = null;
    }
}

public class MyQueue2 {
    QueueNode front, rear;

    MyQueue2() {

    }
    //Function to push an element into the queue.
    void push(int a) {
        QueueNode newNode = new QueueNode(a);
        if (rear == null) {
            rear = newNode;
            front = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    //Function to pop front element from the queue.
    int pop() {
        int val = -1;
        if (front != null) {
            val = front.data;
            front = front.next;
        }
        if (front == null) {
            rear = null;
        }
        return val;
    }
}
