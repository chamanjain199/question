package geeksForGeeks.tree;

class Res {
    Node pre;
    Node succ;
}

public class PredecessorAndSuccessor {

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        Node copyRoot = root;
        while (copyRoot != null) {
            if (key >= copyRoot.data) {
                copyRoot = copyRoot.right;
            } else {
                s.succ = copyRoot;
                copyRoot = copyRoot.left;
            }
        }
        while (root != null) {
            if (key > root.data) {
                p.pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }

    }

    public static void main(String[] args) {

    }
}
