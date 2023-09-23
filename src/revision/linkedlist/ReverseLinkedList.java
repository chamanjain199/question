package revision.linkedlist;

public class ReverseLinkedList {
    private Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node rofl = head.next;
            head.next = newHead;
            newHead = head;
            head = rofl;
        }
        return newHead;
    }
}
