package revision.linkedlist;


public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode headc = head;
        while (headc != null) {
            headc = headc.next;
            len++;
        }
        int len2 = len / k;
        ListNode pre = null;
        ListNode last;
        ListNode next = head;
        ListNode toReturn = head;
        for (int i = 0; i < len2; i++) {
            int j = 1;
            last = pre;
            pre = next;
            while (j < k) {
                next = next.next;
                j++;
            }
            ListNode temp = next;
            next = next.next;
            temp.next = null;
            if (last != null) {
                last.next = reverse(pre);
            } else {
                toReturn = reverse(pre);
            }
        }
        if (pre != null)
            pre.next = next;

        return toReturn;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);
        System.out.println(reverseKGroup(one, 2));

    }

    private static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode rofl = head.next;
            head.next = newHead;
            newHead = head;
            head = rofl;
        }
        return newHead;
    }
}
