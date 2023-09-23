package revision.linkedlist;

public class DetectCycle {
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && slow != fast);

        return fast == slow;

    }
}
