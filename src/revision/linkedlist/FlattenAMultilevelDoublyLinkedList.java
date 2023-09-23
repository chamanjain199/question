package revision.linkedlist;

public class FlattenAMultilevelDoublyLinkedList {
// wrong or not complete
Node flatten(Node root)
{
    Node newHead = new Node(0);
    Node pre = root;
    flattenTry(root);
    print(pre);
    return pre;
}
    public void print(Node node){
        if(node!=null){
            System.out.println(node.data);
            print(node.next);
        }
    }
    public void flattenTry(Node head) {

        if (head == null) {
            return;
        }


        if (head.bottom != null) {
            Node next=head.next;
            head.next=head.bottom;
            head.bottom=null;
            head.next.next=next;
            flattenTry(head.next);
        }

        if (head.next != null) {
            flattenTry(head.next);
        }
    }

    public static void main(String[] args) {

    }
}
