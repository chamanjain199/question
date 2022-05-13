package leetcode.top100.liked;

public class DiameterOfBinaryTree {
    public static int sum=0;
    public static int diameterOfBinaryTree(TreeNode root) {
         diameter(root);
         return sum;
    }

    public static int diameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Lmax = 1+diameter(node.left);
        int Rmax = 1+diameter(node.right);
         sum=Math.max(Lmax+Rmax-2,sum);
        return Math.max(Lmax, Rmax);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
//        treeNode.right=new TreeNode(3);
//        treeNode.left.left=new TreeNode(4);
//        treeNode.left.right=new TreeNode(5);

        System.out.println(diameterOfBinaryTree(treeNode));
    }
}
