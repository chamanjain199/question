package leetcode.top100.liked;


public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = new ListNode();
        ListNode newList = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;

        }
        if (list1 != null) {
            head.next = list1;
        } else if (list2 != null) {
            head.next = list2;

        }
        return newList.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;


        int cur = Math.min(list1.val, list2.val);
        while (list1 != null && list2 != null) {
            if (cur < list2.val) {
                cur = list1.val;
//                list1 = list1.next;
            } else {
                ListNode temp = list1.next;
                list1.next = list2;
                list1.next.next = temp;
                list2 = list2.next;
            }

        }
        if (list2 != null) {
            list1.next = list2;
        }
        return list1;


    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode();
        l1.val = 10;
        l1.next = new ListNode(20);
        l1.next.next = new ListNode(30);

        ListNode l2 = new ListNode();
        l2.val = 12;
        l2.next = new ListNode(15);
        l2.next.next = new ListNode(25);


        ListNode r = mergeTwoLists2(l1, l2);
        System.out.println(r);
    }
}
