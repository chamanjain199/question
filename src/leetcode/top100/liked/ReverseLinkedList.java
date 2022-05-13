package leetcode.top100.liked;

public class ReverseLinkedList {

    public ListNode reverseListMy(ListNode head) {
        ListNode prev = null;
        ListNode newLink = head;
        ListNode currentNode = head;
        while (newLink != null) {
            newLink = newLink.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = newLink;
        }
        return prev;

    }
    public ListNode reverseListMy1(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next=newhead;
            newhead=head;
            head=next;
        }
        return newhead;
    }
    public static void main(String[] args) {

    }
}
