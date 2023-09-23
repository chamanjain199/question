package revision.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode mid = middle(head);
        ListNode rev = reverse(mid);
        while (rev.next != null) {
            ListNode t1 = head.next;
            ListNode t2 = rev.next;
            head.next = rev;
            rev.next = t1;
            rev = t2;
            head = t1;
        }
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        while (head != null && head.next != null) {
            slow = slow.next;
            head = head.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode rol = head.next;
            head.next = newHead;
            newHead = head;
            head = rol;
        }
        return newHead;
    }
}
