package leetcode.top100.liked;

public class MiddleNodeLinedList {
    private static ListNode midNode(ListNode head) {
        ListNode mid=head;
        while (mid!=null && mid.next!=null){
            head=head.next;
            mid=mid.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        System.out.println(midNode(node).val);

    }
}
