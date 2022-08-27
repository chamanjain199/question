package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {
    List<TreeNode> finalList = new ArrayList<>();
    int n;

//    public void clone(TreeNode treeNode, TreeNode clone) {
//        if (treeNode == null) {
//            return;
//        }
//        clone.val = treeNode.val;
//        if (treeNode.left != null) {
//            clone.left = new TreeNode();
//            clone(treeNode.left, clone.left);
//        }
//        if (treeNode.right != null) {
//            clone.right = new TreeNode();
//            clone(treeNode.right, clone.right);
//        }
//    }

    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n);
    }

    public List<TreeNode> helper(int n) {

        if (n == 1) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            TreeNode node = new TreeNode(0);
            treeNodes.add(node);
            return treeNodes;
        } else {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> left = helper(i);
                List<TreeNode> right = helper(n - i - 1);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(0);
                        node.left = l;
                        node.right = r;
                        treeNodes.add(node);
                    }
                }
            }
            return treeNodes;
        }

    }

    public static void main(String[] args) {
        AllPossibleFBT obj = new AllPossibleFBT();
        obj.allPossibleFBT(7);
        System.out.println(obj.finalList.size());
        System.out.println(obj.finalList);

    }
}
