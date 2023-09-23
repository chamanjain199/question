package revision.linkedlist;

public class ReverseAsublistoFAlinkedList {
    public static Node reverseBetween(Node head, int m, int n) {
        Node p1 = null;
        Node p2;
        Node p3;
        Node h1 = head;
        Node p2end;
        Node p1end =null;
        int i = 1;
        while (i < n) {
            h1 = h1 == null ? head : h1.next;
            i++;
        }
        p3 = h1.next;
        h1.next = null;
        h1 = null;
        i = 1;
        while (i < m) {
            h1 = h1 == null ? head : h1.next;
            i++;
        }
        if (h1 != null) {
            p1end=h1;
            p2 = h1.next;
            p2end=h1.next;
        }else{
            p2=head;
            p2end=head;
        }
        p2 = reverse(p2);
        if (m > 1) {
            p1 = head;
        }
        if (p1end != null) {
            p1end.next = p2;
        }
        if(p2end!=null){
            p2end.next=p3;
        }

        return p1 == null ? p2 : p1;

    }

    private static Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node rofl = head.next;
            head.next = newHead;
            newHead = head;
            head = rofl;
        }
        return newHead;
    }
}
