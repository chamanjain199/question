package geeksForGeeks.linkedList;

public class CopyListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        Node dummyHead = head;
        while (dummyHead != null) {
            Node clone = new Node(dummyHead.data);
            Node temp = dummyHead.next;
            dummyHead.next = clone;
            clone.next = temp;
            dummyHead = dummyHead.next.next;
        }
        dummyHead = head;
        while (dummyHead != null) {
            if(dummyHead.random!=null)
                dummyHead.next.random = dummyHead.random.next;
            dummyHead = dummyHead.next.next;
        }
        Node newHead = new Node(0);
        Node temp = newHead;
        dummyHead = head;
        while (dummyHead != null) {
            temp.next = dummyHead.next;
            dummyHead.next = dummyHead.next.next;
            temp = temp.next;
            dummyHead = dummyHead.next;
        }
        return newHead.next;
    }

    Node copyList(Node head) {
        Node dummyHead = head;
        while (dummyHead != null) {
            Node clone = new Node(dummyHead.data);
            Node temp = dummyHead.next;
            dummyHead.next = clone;
            clone.next = temp;
            dummyHead = dummyHead.next.next;
        }
        dummyHead = head;
        while (dummyHead != null) {
            if(dummyHead.arb!=null)
                dummyHead.next.arb = dummyHead.arb.next;
            dummyHead = dummyHead.next.next;
        }
        Node newHead = new Node(0);
        Node temp = newHead;
        dummyHead = head;
        while (dummyHead != null) {
            temp.next = dummyHead.next;
            dummyHead.next = dummyHead.next.next;
            temp = temp.next;
            dummyHead = dummyHead.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
