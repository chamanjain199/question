package leetcode.top100.liked;

public class DeleteNodeInLinkedList {
    public static void deleteNodeNoNeedTopull(ListNode node) {
        ListNode secondLastNode = null;
        while (node.next != null) {
            secondLastNode = node;
            node.val = node.next.val;
            node = node.next;
        }
        secondLastNode.next = null;

    }
    public static void deleteNodeBest(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        deleteNodeBest(node.next);
        while (node != null) {
            System.out.println(node.val + "");
            node = node.next;
        }

    }
}
