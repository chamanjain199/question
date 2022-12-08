package geeksForGeeks.linkedList;

public class ReverseNodesInKGroup {


    public static ListNode reverseKGroup(ListNode head, int k) {

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int len2 = len - (len % k);
        int i = 0;
        ListNode newHead;
        ListNode newTail = head;
        ListNode prevNode = null;
        ListNode curNode = null;
        while (i < k) {
            curNode = head;
            head = head.next;
            curNode.next = prevNode;
            prevNode = curNode;
            i++;
        }
        newHead = curNode;
        len2 = len2 - k;
        i = 0;

        while (len2 > 0) {
            prevNode = null;
            ListNode tempTail = head;
            while (len2 > 0 && i < k) {
                curNode = head;
                head = head.next;
                curNode.next = prevNode;
                prevNode = curNode;
                i++;
                len2--;
            }
            newTail.next = curNode;
            newTail = tempTail;
            i = 0;
        }
        newTail.next = head;
        return newHead;
    }

    public static Node reverse(Node node, int k) {

        int len = 0;
        Node temp = node;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int i = 0;
        Node newHead;
        Node newTail = node;
        Node prevNode = null;
        Node curNode = null;
        while (i < k) {
            curNode = node;
            node = node.next;
            curNode.next = prevNode;
            prevNode = curNode;
            i++;
        }
        newHead = curNode;
        len = len - k;
        i = 0;

        while (len > 0) {
            prevNode = null;
            Node tempTail = node;
            while (len > 0 && i < k) {
                curNode = node;
                node = node.next;
                curNode.next = prevNode;
                prevNode = curNode;
                i++;
                len--;
            }
            newTail.next = curNode;
            newTail = tempTail;
            i = 0;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(7);
        n1.next.next = new ListNode(8);
        n1.next.next.next = new ListNode(3);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(3);
        System.out.println(reverseKGroup(n1, 2));
    }
}
