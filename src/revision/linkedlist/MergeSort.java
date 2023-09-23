package revision.linkedlist;

public class MergeSort {
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return merge(left, right);
    }

    private static Node merge(Node left, Node right) {
        Node newHead = new Node(0);
        Node temp = newHead;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                newHead.next = new Node(left.data);
                left = left.next;
            } else {
                newHead.next = new Node(right.data);
                right = right.next;
            }
            newHead = newHead.next;
        }
        newHead.next = left == null ? right : left;
        return temp.next;
    }

    private static Node getMid(Node head) {
        Node preMid = null;
        while (head != null && head.next != null) {
            preMid = preMid == null ? head : preMid.next;
            head = head.next.next;
        }
        Node mid = null;
        if (preMid != null) {
            mid = preMid.next;
            preMid.next = null;
        }
        return mid;
    }

    public static void main(String[] args) {

    }
}
