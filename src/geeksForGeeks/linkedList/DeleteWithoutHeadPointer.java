package geeksForGeeks.linkedList;

public class DeleteWithoutHeadPointer {
    void deleteNode(Node del) {
        while (del.next.next != null) {
            del.data = del.next.data;
            del = del.next;
        }
        del.data = del.next.data;
        del.next = null;
    }

    protected  String name="kaka";


    public static void main(String[] args) {

    }
}
