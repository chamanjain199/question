package geeksForGeeks.linkedList;

public class MergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    static ListNode getMid(ListNode node) {
        ListNode midPrev = null;
        while (node != null && node.next != null) {
            midPrev = (midPrev == null) ? node : midPrev.next;
            node = node.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    static ListNode merge(ListNode first, ListNode second) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                newHead.next = first;
                newHead = newHead.next;
                first = first.next;
            } else {
                newHead.next = second;
                newHead = newHead.next;
                second = second.next;
            }
        }
        newHead.next = first != null ? first : second;
        return temp.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return merge(left, right);
    }

    static Node getMid(Node node) {
        Node midPrev = null;
        while (node != null && node.next != null) {
            midPrev = (midPrev == null) ? node : midPrev.next;
            node = node.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    static Node merge(Node first, Node second) {
        Node newHead = new Node(0);
        Node temp = newHead;
        while (first != null && second != null) {
            if (first.data <= second.data) {
                newHead.next = first;
                newHead = newHead.next;
                first = first.next;
            } else {
                newHead.next = second;
                newHead = newHead.next;
                second = second.next;
            }
        }
        newHead.next = first != null ? first : second;
        return temp.next;
    }

    public static void main(String[] args) {

    }
}
