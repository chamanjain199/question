package geeksForGeeks.linkedList;

public class ReorderList {
    static Node reorderlist(Node head) {
        Node mid = head;
        Node temp = head;
        Node temp2 = head;
        while (temp != null && temp.next != null) {
            mid = mid.next;
            temp = temp.next.next;
        }
        Node secondHalf = mid.next;
        mid.next = null;
        secondHalf = reverseList(secondHalf);
        Node res = new Node(0);
        Node newHead = res;
        boolean b = true;
        while (temp2 != null && secondHalf != null) {
            if (b) {
                res.next = head;
                head = head.next;
                b = false;
            } else {
                res.next = secondHalf;
                secondHalf = secondHalf.next;
                b = true;
            }
            res = res.next;
        }
        res.next=head!=null?head:secondHalf;
        return newHead.next;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node currentNode = null;
        while (head != null) {
            currentNode = head;
            head = head.next;
            currentNode.next = prev;
            prev = currentNode;
        }
        return currentNode;
    }


    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);

        Node r = reorderlist(n);
        System.out.println(r);
    }
}
