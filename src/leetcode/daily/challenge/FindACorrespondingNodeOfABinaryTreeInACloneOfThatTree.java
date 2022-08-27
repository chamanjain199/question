package leetcode.daily.challenge;

import java.util.LinkedList;
import java.util.Queue;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        return rec(cloned, original, target);
    }

    private TreeNode rec(TreeNode cloned, TreeNode original, TreeNode target) {

        if (target == original) {
            return cloned;
        }
        if (original == null) {
            return null;
        }

        TreeNode node = rec(cloned.left, original.left, target);
        if (node != null) {
            return node;
        }
        node = rec(cloned.right, original.right, target);

        return node;
    }

    public static void main(String[] args) {

    }
}
