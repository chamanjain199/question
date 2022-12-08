package geeksForGeeks.queue;

public class Driver {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
    }
}
