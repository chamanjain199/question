package revision.linkedlist;

public class RemoveLoopInLinkedList {
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null && slow != fast);

        if (slow != fast) {
            return;
        }
        if (slow == head) {
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
}
