package revision.linkedlist;

import java.util.Map;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode p1=headA;
        ListNode p2=headB;
        while (p1 != null && p2 != null) {
            len1++;
            len2++;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        int diff = Math.abs(len2 - len1);

        if (len1 > len2) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (len2 > len1) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while ( headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}
