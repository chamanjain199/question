package geeksForGeeks.linkedList;

public class MergeTwoSortedLinkedLists {
    static Node sortedMerge(Node head1, Node head2) {
        Node newHead = new Node();
        Node temp = newHead;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                newHead.next = head1;
                newHead = newHead.next;
                head1 = head1.next;
            } else {
                newHead.next = head2;
                newHead = newHead.next;
                head2 = head2.next;
            }
        }
        newHead.next = head1 != null ? head1 : head2;
        return temp.next;

    }

    Node mergeKList(Node[] arr, int K) {
        Node mergeList = null;
        for (int i = 0; i < K; i++) {
            mergeList = sortedMerge(mergeList, arr[i]);
        }
        return mergeList;
    }

    static ListNode mergeSortedLinkedList(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                newHead.next = head1;
                newHead = newHead.next;
                head1 = head1.next;
            } else {
                newHead.next = head2;
                newHead = newHead.next;
                head2 = head2.next;
            }
        }
        newHead.next = head1 != null ? head1 : head2;
        return temp.next;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergeList = null;
        int K = lists.length;
        for (int i = 0; i < K; i++) {
            mergeList = mergeSortedLinkedList(mergeList, lists[i]);
        }
        return mergeList;
    }
//another approach //MergeKSortedArrays // priority queue

    public static void main(String[] args) {
        Node first = new Node(5);
        first.next = new Node(10);
        first.next.next = new Node(15);
        first.next.next.next = new Node(40);

        Node second = new Node(2);
        second.next = new Node(3);
        second.next.next = new Node(20);
        Node res = sortedMerge(first, second);
        System.out.println(res);
    }
}
