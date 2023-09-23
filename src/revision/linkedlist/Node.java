package revision.linkedlist;

public class Node {
    int val;
    int key;
    int data;

    Node next;
    Node random;
    Node bottom;

    public Node prev;
    public Node child;

    public Node(int val) {
        this.val = val;
        this.data = val;
        this.next = null;
        this.random = null;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.data = val;
        this.next = null;
        this.random = null;
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
