package geeksForGeeks.recurtion;

import leetcode.top100.liked.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head.next;
        ListNode nextLink = newHead.next;
        newHead.next = head;
        head.next = swapPairs(nextLink);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode.print(head);
        ListNode newHead = swapPairs(head);
        ListNode.print(newHead);
    }
}
