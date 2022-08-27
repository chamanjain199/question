package geeksForGeeks.recurtion;

import java.util.HashMap;
import java.util.List;

class Tree {
    int data;
    Tree left, right, random;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
        random = null;
    }
}

public class CloneABinaryTreeWithRandomNode {

    HashMap<Integer, Integer> mapping = new HashMap<>();

    public Tree cloneTree(Tree tree) {
        Tree cloned = new Tree(tree.data);
        mapping.put(tree.data, 1);
        clone(tree, cloned);
        return cloned;
    }

    public void clone(Tree treeNode, Tree clone) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.left != null) {
            mapping.put(treeNode.left.data, 1);
            clone.left = new Tree(treeNode.left.data);
            clone(treeNode.left, clone.left);
        }
        if (treeNode.right != null) {
            mapping.put(treeNode.right.data, 1);
            clone.right = new Tree(treeNode.right.data);
            clone(treeNode.right, clone.right);
        }
        if (treeNode.random != null) {
            clone.random = new Tree(treeNode.random.data);
            if (mapping.get(treeNode.random) == null) {
                clone(treeNode.random, clone.random);
            }
        }
    }

    public static void main(String[] args) {
       // 6
        //5 10 L 5 15 R 15 17 L 10 15 X 15 5 X 17 15 X

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.random = root;
        CloneABinaryTreeWithRandomNode cloneABinaryTreeWithRandomNode = new CloneABinaryTreeWithRandomNode();
        Tree clone = cloneABinaryTreeWithRandomNode.cloneTree(root);
        System.out.println(clone);

        if (clone == root)
            System.out.println("0");
        else {
            if (printInorder(root, clone))
                System.out.println("1");

            else
                System.out.println("0");

        }

    }

    public static boolean printInorder(Tree a, Tree b) {
        if ((a == null) && (b == null))
            return true;

        if (a != null && b != null) {
            boolean check = ((a.data == b.data) && printInorder(a.left, b.left) && printInorder(a.right, b.right));

            if (a.random != null && b.random != null)
                return (check && (a.random.data == b.random.data));

            if (a.random == b.random)
                return check;

            return false;

        }


        return false;

    }
}
