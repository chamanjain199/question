package revision.linkedlist;


public class NthNodeFromEndOfLinkedList {
    int getNthFromLast(Node head, int n) {
        return 0;
    }

    ListNode getNthFromLastU(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
}
