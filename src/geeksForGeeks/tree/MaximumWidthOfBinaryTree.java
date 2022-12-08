package geeksForGeeks.tree;

import java.util.LinkedList;
import java.util.Queue;


class TreeNodeWithInfo {
    int key;
    TreeNode treeNode;
    int index;

    TreeNodeWithInfo(int key, TreeNode treeNode, int index) {
        this.key = key;
        this.treeNode = treeNode;
        this.index = index;
    }

}

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < currentSize; i++) {
                Pair current = queue.poll();

                if (i == 0)
                    first = current.index;

                if (i == currentSize - 1)
                    last = current.index;

                if (current.node.left != null)
                    queue.add(new Pair(current.node.left, 2 * (current.index - minIndex) + 1));

                if (current.node.right != null)
                    queue.add(new Pair(current.node.right, 2 * (current.index - minIndex) + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
        // root.left.left = new TreeNode(5);
        //root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//
//        root.right.left.right = new TreeNode(6);
//        root.right.left.right.right = new TreeNode(7);

//
//        root.left.right.right = new TreeNode(8);
//        root.left.right.right.left = new TreeNode(9);
//        root.left.right.right.right = new TreeNode(100);
//
//        root.left.right.right.left.left = new TreeNode(10);
//        root.left.right.right.left.left.left = new TreeNode(11);
//
//        root.left.right.right.left.right = new TreeNode(12);
//        root.left.right.right.left.right.left = new TreeNode(13);
//
//        root.left.right.right.right.left = new TreeNode(14);
//        root.left.right.right.right.right = new TreeNode(15);
//
//        root.left.right.right.right.left.right = new TreeNode(16);
//        root.left.right.right.right.right.right = new TreeNode(17);

        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(root));
    }
}
