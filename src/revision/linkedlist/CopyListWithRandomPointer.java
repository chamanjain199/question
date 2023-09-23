package revision.linkedlist;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        Node newHeadRef = new Node(0);
        Node newHead = new Node(head.val);
        newHeadRef.next = newHead;
        oldToNew.put(head, newHead);
        while (head.next != null) {
            head = head.next;
            newHead.next = new Node(head.val);
            oldToNew.put(head, newHead.next);
            newHead = newHead.next;
        }
        for (Map.Entry<Node, Node> entry : oldToNew.entrySet()) {
            if (entry.getKey().random != null) {
                entry.getValue().random = oldToNew.get(entry.getKey().random);
            }
        }
        return newHeadRef.next;
    }
}
