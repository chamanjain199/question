package revision.tree;

public class PredecessorAndSuccessor {
    static Node pre, suc;

    public static void findPreSuc(Node root, int key) {
        if (root != null) {
            if (root.data < key) {
                if (pre == null || root.data > pre.data) {
                    pre = root;
                }
            } else if (root.data > key) {
                if (suc == null || root.data < suc.data) {
                    suc = root;
                }
            }
            findPreSuc(root.left, key);
            findPreSuc(root.right, key);
        }
    }
}
