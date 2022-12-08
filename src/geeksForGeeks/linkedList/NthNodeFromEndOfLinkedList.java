package geeksForGeeks.linkedList;

public class NthNodeFromEndOfLinkedList {
    int getNthFromLast(Node head, int n) {
        Node fast = head;
        Node slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
