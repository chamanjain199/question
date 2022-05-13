package leetcode.top100.liked;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEndMy1(ListNode head, int n) {

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int removeFromStart = length - n;
        if (removeFromStart == 0) {
            head = head.next;
            return head;
        }

        ListNode temp2 = head;
        while (temp2 != null && removeFromStart > 1) {
            temp2 = temp2.next;
            removeFromStart--;
        }

        if (temp2.next != null) {
            temp2.next = temp2.next.next;
        } else {
            return null;
        }
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while ( fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            head = head.next;
        }


        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next=new ListNode(3);
//        listNode.next.next.next=new ListNode(4);
//        listNode.next.next.next.next=new ListNode(5);
        ListNode result = removeNthFromEnd(listNode, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }
}
