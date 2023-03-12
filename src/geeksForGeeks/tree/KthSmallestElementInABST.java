package geeksForGeeks.tree;

public class KthSmallestElementInABST {
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int l = kthSmallest(root.left, k);
        if (l > 0) {
            return l;
        }
        count = count + 1;
        if (count == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }

    public int kthLargest(Node root, int K) {
        if (root == null) return 0;
        int l = kthLargest(root.right, K);
        if (l > 0) {
            return l;
        }
        count = count + 1;
        if (count == K) {
            return root.data;
        }
        return kthLargest(root.left, K);
    }


    public static void main(String[] args) {

    }
}
