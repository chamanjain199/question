package geeksForGeeks.linkedList;

public class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        int len = 1;
        ListNode secondLastNode = head;
        while (secondLastNode.next != null) {
            len++;
            secondLastNode = secondLastNode.next;
        }
        if (k == len) {
            return head;
        }
        k = k % len;
        if (k == 0 || k == len) {
            return head;
        }
        int firstHalfLen = len - k;
        ListNode secondHalf;
        ListNode firstHalf = head;
        while (firstHalfLen > 1) {
            firstHalfLen--;
            head = head.next;
        }
        secondHalf = head.next;
        head.next = null;
        secondLastNode.next = firstHalf;
        return secondHalf;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        System.out.println(rotateRight(n1, 4));
    }
}
