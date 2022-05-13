package leetcode.top100.liked;

public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }




    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);

//        root2.right = new TreeNode(4);
//        root2.right.left = new TreeNode(1);
//        root2.right.right = new TreeNode(7);

        invertTree(root2);
    }
}
