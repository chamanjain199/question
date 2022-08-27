package geeksForGeeks.recurtion;

import leetcode.top100.liked.ListNode;

import java.util.List;

public class ReorderList {
    public static ListNode reorderList(ListNode head) {
        ListNode temp = head;
        ListNode midToEnd = reverseList(middleNode(temp));
        ListNode newHead = new ListNode();
        ListNode newHeadTracker = new ListNode();
        newHeadTracker.next=head;
        while (midToEnd != null && head.next!=null) {
            newHead.next=head;
            head = head.next;
            newHead=newHead.next;
            newHead.next=midToEnd;
            midToEnd = midToEnd.next;
            newHead=newHead.next;
        }
        return newHeadTracker.next;
    }


    public static ListNode middleNode(ListNode head) {
        ListNode mid = head;
        while (head != null && head.next != null) {
            mid = mid.next;
            head = head.next.next;
        }
        return mid;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode restList = head.next;
            ListNode tempNewNode = head;
            tempNewNode.next = newHead;
            newHead = tempNewNode;
            head = restList;
        }
        return newHead;
    }


    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        print(head.next);
    }

    public static void printInRO(ListNode head) {
        if (head == null) {
            return;
        }
        printInRO(head.next);
        System.out.println(head.val);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode track = head;
        ListNode previous = null;
        while (track != null) {
            if (track.val == val) {
                if (previous == null) {
                    head = head.next;
                } else {
                    previous.next = track.next;
                }
            } else {
                previous = track;
            }
            track = track.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(4);
//        root.next.next.next.next = new ListNode(5);
//        root.next.next.next.next.next = new ListNode(6);
//        root.next.next.next.next.next.next = new ListNode(7);
//        root.next.next.next.next.next.next.next = new ListNode(8);

        //root=removeElements(root, 3);
        root = reorderList(root);
        print(root);
    }
}
