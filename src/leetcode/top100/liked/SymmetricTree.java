package leetcode.top100.liked;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {


    private static boolean isSymmetricRec(TreeNode n1, TreeNode n2) {
        if(n1==null && n2==null){
            return true;
        }
        if( n2==null){
            return false;
        }
        if(n1==null){
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }
        if (isSymmetricRec(n1.left, n2.right) &&
                isSymmetricRec(n2.right, n1.left)) {
            return true;
        }
        return false;

    }


    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return  isSymmetricRec(root.left,root.right);
    }

    public static void main(String[] args) {

    }
}
