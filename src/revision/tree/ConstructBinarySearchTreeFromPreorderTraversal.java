package revision.tree;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderRec(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorderRec(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) return null;

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstFromPreorderRec(preorder, root.val);
        root.right = bstFromPreorderRec(preorder, bound);
        return root;
    }
}
