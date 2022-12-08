package geeksForGeeks.queue;

public class MyQueue {
    int front, rear;
    int arr[] = new int[100005];
    int size = 100005;

    MyQueue() {
        front = -1;
        rear = -1;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        rear = (rear + 1) % size;
        if (rear != front)
            arr[rear] = x;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        if (rear != -1 && rear != front) {
            front = (front + 1) % size;
            return arr[front];
        }
        return -1;
    }
}
