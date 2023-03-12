package geeksForGeeks.tree;

class LargestBinaryTreeInfo {
    int size;
    int min;
    int max;

    public LargestBinaryTreeInfo(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

public class LargestBST {
    public int largestBst(TreeNode root) {
        return findLargestBst(root).size;
    }

    public LargestBinaryTreeInfo findLargestBst(TreeNode root) {
        if (root == null) return new LargestBinaryTreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        LargestBinaryTreeInfo left = findLargestBst(root.left);
        LargestBinaryTreeInfo right = findLargestBst(root.right);
        if (left.max < root.val && right.min > root.val) {

            return new LargestBinaryTreeInfo((left.size + right.size + 1), Math.min(root.val, left.min), Math.max(root.val, right.max));
        } else {
            return new LargestBinaryTreeInfo(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {

    }
}
