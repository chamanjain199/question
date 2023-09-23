package revision.linkedlist;

public class PalindromeLinkedList {
    boolean isPalindrome(Node head)
    {
        Node mid = getMidNode(head);
        Node rev = reverse(mid);

        while (rev != null && head != null) {
            if (rev.data != head.data) return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
    private Node getMidNode(Node fast) {
        Node midPre = null;

        while (fast != null && fast.next != null) {
            midPre = midPre == null ? fast : midPre.next;
            fast = fast.next.next;
        }
        if(midPre==null){
            return null;
        }
        Node mid = midPre.next;
        midPre.next = null;
        return mid;
    }

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
