package geeksForGeeks.tree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addAllNodeTillLastLeftNode(root);
    }

    private void addAllNodeTillLastLeftNode(TreeNode root) {
        if (root != null) {
            stack.add(root);
            while (root.left != null) {
                root = root.left;
                stack.add(root);
            }
        }
    }

    public int next() {
        TreeNode curNode = stack.pop();
        int val = curNode.val;
        addAllNodeTillLastLeftNode(curNode.right);
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
//        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(20);
        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());


//        System.out.println(bSTIterator.next());    // return 3
//        System.out.println(bSTIterator.next());    // return 7
//        System.out.println(bSTIterator.hasNext()); // return True
//        System.out.println(bSTIterator.next());    // return 9
//        System.out.println(bSTIterator.hasNext()); // return True
//        System.out.println(bSTIterator.next());    // return 15
//        System.out.println(bSTIterator.hasNext()); // return True
//        System.out.println(bSTIterator.next());    // return 20
//        System.out.println(bSTIterator.hasNext()); // return False

    }
}
