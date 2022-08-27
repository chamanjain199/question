package geeksForGeeks.recurtion;

public class TreeNode {
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

    public void print(TreeNode treeNode, StringBuilder sb) {
        if (treeNode == null) {

            return;
        }
        sb.append(treeNode.val + " ");
        print(treeNode.left,sb);
        print(treeNode.right,sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(this, sb);
        return sb.toString();
    }
}
