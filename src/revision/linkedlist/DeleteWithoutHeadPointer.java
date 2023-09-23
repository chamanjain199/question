package revision.linkedlist;


public class DeleteWithoutHeadPointer {
    void deleteNode(Node del) {
        if (del.next == null) {
            del = null;
        }
        while (del != null && del.next != null) {
            del.val = del.next.val;
            del = del.next;
        }

    }
}
