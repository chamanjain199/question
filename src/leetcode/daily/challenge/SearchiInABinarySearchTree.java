package leetcode.daily.challenge;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SearchiInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currentNode=queue.remove();
            if(currentNode.val==val){
                return currentNode;
            }
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }

        }
        return null;



    }
    public static void main(String[] args) {

    }
}
