package geeksForGeeks.linkedList;

public class FlatteningALinkedList {

    public Node flatten(Node root) {
        Node flattenList = null;
        while (root != null) {
            flattenList = sortedMerge(flattenList, root);
            root = root.next;
        }
        return flattenList.bottom;
    }

    static Node sortedMerge(Node head1, Node head2) {
        Node newHead = new Node();
        Node temp = newHead;
        Node pointerOne = head1;
        Node pointerTwo = head2;
        while (pointerOne != null && pointerTwo != null) {
            if (pointerOne.data <= pointerTwo.data) {
                newHead.bottom = pointerOne;
                newHead = newHead.bottom;
                pointerOne = pointerOne.bottom;
            } else {
                newHead.bottom = pointerTwo;
                newHead = newHead.bottom;
                pointerTwo = pointerTwo.bottom;
            }
        }
        while (pointerOne != null) {
            newHead.bottom = pointerOne;
            newHead = newHead.bottom;
            pointerOne = pointerOne.bottom;
        }
        while (pointerTwo != null) {
            newHead.bottom = pointerTwo;
            newHead = newHead.bottom;
            pointerTwo = pointerTwo.bottom;
        }
        return temp.bottom;

    }

    public static void main(String[] args) {

    }
}
