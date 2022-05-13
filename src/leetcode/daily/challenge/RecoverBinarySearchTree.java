package leetcode.daily.challenge;

public class RecoverBinarySearchTree {
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
        }
        if (first != null && first.val > root.val) {
            second = root;
        }
        prev = root;
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
//        root.left.left = new TreeNode(-4);
//        root.left.right = new TreeNode(1);
//        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(7);
//        root.right.right.right = new TreeNode(8);
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
        obj.recoverTree(root);
    }
}
