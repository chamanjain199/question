package geeksForGeeks.tree;

public class DiameterOfBinaryTree {
    int maxDia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeCa(root);
        return maxDia;
    }
    public int diameterOfBinaryTreeCa(TreeNode root) {
        if(root!=null){
            int leftLen = diameterOfBinaryTreeCa(root.left);
            int rightLen = diameterOfBinaryTreeCa(root.right);
            maxDia = Math.max(maxDia, leftLen + rightLen);
            return 1+Math.max(leftLen, rightLen);
        }
        return 0;
    }
}
