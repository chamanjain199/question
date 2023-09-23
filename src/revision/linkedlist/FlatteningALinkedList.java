package revision.linkedlist;

public class FlatteningALinkedList {
    Node flatten(Node root) {
        Node ans = null;
        while (root != null) {
            ans = flatten(root, ans);
            root = root.next;
        }
        return ans;
    }

    private Node flatten(Node root, Node ans) {
        Node newNode = new Node(0);
        Node temp = newNode;
        while (root != null && ans != null) {
            if (root.data <= ans.data) {
                newNode.bottom = new Node(root.val);
                root = root.bottom;
            } else {
                newNode.bottom = new Node(ans.data);
                ans = ans.bottom;
            }
            newNode = newNode.bottom;
        }
        while (root != null) {
            newNode.bottom = new Node(root.val);
            root = root.bottom;
            newNode = newNode.bottom;
        }
        while (ans != null) {
            newNode.bottom = new Node(ans.val);
            ans = ans.bottom;
            newNode = newNode.bottom;
        }
        return temp.bottom;
    }
}
