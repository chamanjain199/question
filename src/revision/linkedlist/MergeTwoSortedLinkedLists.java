package revision.linkedlist;

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newHead.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newHead.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            newHead = newHead.next;
        }
        while (list1 != null) {
            newHead.next = new ListNode(list1.val);
            list1 = list1.next;
            newHead = newHead.next;
        }
        while (list2 != null) {
            newHead.next = new ListNode(list2.val);
            list2 = list2.next;
            newHead = newHead.next;

        }
        return newHead.next;
    }
}
