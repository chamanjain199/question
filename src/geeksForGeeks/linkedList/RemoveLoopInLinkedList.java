package geeksForGeeks.linkedList;


public class RemoveLoopInLinkedList {

    static class Node {
        int data;
        Node next;
    }

    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (fast != null && fast.next != null && slow != fast);
        if (slow != fast)
            return;

        if (slow == head) {
            slow = slow.next;
            while (slow.next != head) {
                slow = slow.next;
            }
            slow.next = null;
        } else {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            fast.next = null;
        }
    }

    public static void main(String[] args) {


    }
}
