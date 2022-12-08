package geeksForGeeks.linkedList;

import static geeksForGeeks.linkedList.ReverseLinkedList.reverseList;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow= reverseList(slow);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = null;
        ListNode copy=head;
        while (copy != null) {
            currentNode = copy;
            copy = copy.next;
            currentNode.next = prev;
            prev = currentNode;
        }
        return currentNode;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(2);
        n1.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(n1));
    }
}
