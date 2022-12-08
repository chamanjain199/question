package geeksForGeeks.linkedList;

public class ReverseLinkedList {


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = null;
        while (head != null) {
            currentNode = head;
            head = head.next;
            currentNode.next = prev;
            prev = currentNode;
        }
        return currentNode;
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

    public static Node reverseBetween(Node head, int m, int n) {
        Node firstHalf = head;
        Node firstHalfTail = null;
        Node secondHalf = null;
        Node secondHalfTail = null;
        Node thirdHalf = null;
        int m1 = m;
        int n1 = n;
        if (m == 1) {
            while (n1 > 1) {
                head = head.next;
                n1--;
            }
            firstHalfTail = firstHalf;
            secondHalf = head.next;
            head.next = null;
            firstHalf = reverseList(firstHalf);
            firstHalfTail.next = secondHalf;
        } else {
            m1--;
            while (m1 > 1) {
                head = head.next;
                m1--;
            }
            firstHalfTail = head;
            secondHalf = head.next;
            head.next = null;
            secondHalfTail = secondHalf;
            head = secondHalf;
            n1 = n1 - m;
            while (n1 > 0) {
                head = head.next;
                n1--;
            }
            thirdHalf = head.next;
            head.next = null;
            secondHalf = reverseList(secondHalf);
            firstHalfTail.next = secondHalf;
            secondHalfTail.next = thirdHalf;
        }
        return firstHalf;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode firstHalf = head;
        ListNode firstHalfTail = null;
        ListNode secondHalf = null;
        ListNode secondHalfTail = null;
        ListNode thirdHalf = null;
        int m1 = left;
        int n1 = right;
        if (left == 1) {
            while (n1 > 1) {
                head = head.next;
                n1--;
            }
            firstHalfTail = firstHalf;
            secondHalf = head.next;
            head.next = null;
            firstHalf = reverseList(firstHalf);
            firstHalfTail.next = secondHalf;
        } else {
            m1--;
            while (m1 > 1) {
                head = head.next;
                m1--;
            }
            firstHalfTail = head;
            secondHalf = head.next;
            head.next = null;
            secondHalfTail = secondHalf;
            head = secondHalf;
            n1 = n1 - left;
            while (n1 > 0) {
                head = head.next;
                n1--;
            }
            thirdHalf = head.next;
            head.next = null;
            secondHalf = reverseList(secondHalf);
            firstHalfTail.next = secondHalf;
            secondHalfTail.next = thirdHalf;
        }
        return firstHalf;
    }

    public static void main(String[] args) {


        Node n = new Node(44);
        n.next = new Node(73);
        n.next.next = new Node(60);
        n.next.next.next = new Node(100);
        n.next.next.next.next = new Node(57);
        n.next.next.next.next.next = new Node(98);
        n.next.next.next.next.next.next = new Node(32);
        n.next.next.next.next.next.next.next = new Node(79);
        n.next.next.next.next.next.next.next.next = new Node(70);
//        n.next.next.next.next.next.next.next.next.next = new Node(5);
//        n.next.next.next.next.next.next.next.next.next.next = new Node(5);

        reverseBetween(n, 7, 9);
    }
}
