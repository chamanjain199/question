package revision.recustion;


import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode copyHead = head;
        ListNode midNode = middle(head);
        ListNode revNode = reverse(midNode);
        while (revNode.next != null) {
            ListNode temp1 = copyHead.next;
            copyHead.next = revNode;
            ListNode temp2 = revNode.next;
            revNode.next = temp1;
            revNode = temp2;
            copyHead = temp1;
        }
    }

    private ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode restOfTheList = head.next;
            head.next = prev;
            prev = head;
            head = restOfTheList;
        }
        return prev;
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
        ReorderList obj = new ReorderList();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
//        root.next.next.next.next.next = new ListNode(6);
//        root.next.next.next.next.next.next = new ListNode(7);
//        root.next.next.next.next.next.next.next = new ListNode(8);
        obj.print(root);
        obj.reorderList(root);
        obj.print(root);

    }
}
