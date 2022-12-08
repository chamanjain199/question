package geeksForGeeks.linkedList;

public class IntersectionOfTwoLinkedLists {
    int intersectPoint(Node head1, Node head2) {
        int len1 = 0;
        int len2 = 0;
        Node dummyHead1 = head1;
        Node dummyHead2 = head2;
        while (dummyHead1 != null && dummyHead2 != null) {
            len1++;
            len2++;
            dummyHead1 = dummyHead1.next;
            dummyHead2 = dummyHead2.next;
        }
        while (dummyHead1 != null) {
            dummyHead1 = dummyHead1.next;
            len1++;
        }
        while (dummyHead2 != null) {
            dummyHead2 = dummyHead2.next;
            len2++;
        }
        int diff = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else if (len2 > len1) {
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.data;
    }
}
