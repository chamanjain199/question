package revision.tree;

public class KthlargestElementInBST {
    int count = 0;

    public int kthLargest(Node root, int K) {
        if (root == null) return 0;
        int r = kthLargest(root.right, K);
        if (r > 0) {
            return r;
        }
        count = count + 1;
        if (count == K) {
            return root.data;
        }
        return kthLargest(root.left, K);
    }
}
