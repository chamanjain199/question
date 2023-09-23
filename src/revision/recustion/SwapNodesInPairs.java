package revision.recustion;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode nextLink = newHead.next;
        newHead.next=head;
        head.next=swapPairs(nextLink);
        return newHead;
    }


    private void print(ListNode head) {
        if (head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val + " ");
        print(head.next);
    }

    public static void main(String[] args) {
        SwapNodesInPairs obj = new SwapNodesInPairs();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
//        root.next.next.next.next = new ListNode(5);
//        root.next.next.next.next.next = new ListNode(6);
//        root.next.next.next.next.next.next = new ListNode(7);
//        root.next.next.next.next.next.next.next = new ListNode(8);
        obj.print(root);
        obj.swapPairs(root);
        obj.print(root);
    }


}
