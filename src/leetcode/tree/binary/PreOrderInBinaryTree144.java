package leetcode.tree.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


public class PreOrderInBinaryTree144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> elements=new ArrayList<>();
        List<Integer> elements1=Arrays.stream(new int[]{}).boxed().sorted().distinct().collect(Collectors.toList());

        //preOrder(root,elements);
        inOrder(root,elements);

        return elements;
    }
    public TreeNode preOrder(TreeNode root,List<Integer> elements){

        if(root==null){
            return null;
        }
        elements.add(root.val);
        if(root.left!=null){
            TreeNode temp=preOrder(root.left,elements);
            if(temp!=null)
                elements.add(temp.val);
        }
        if(root.right!=null){
            TreeNode temp=preOrder(root.right,elements);
            if(temp!=null)
                elements.add(temp.val);
        }
        return null;

    }
    public TreeNode inOrder(TreeNode root,List<Integer> elements){

        if(root==null){
            return null;
        }

        if(root.left!=null){
            TreeNode temp=preOrder(root.left,elements);
            if(temp!=null)
                elements.add(temp.val);
        }
        elements.add(root.val);
        if(root.right!=null){
            TreeNode temp=preOrder(root.right,elements);
            if(temp!=null)
                elements.add(temp.val);
        }
        return null;

    }
}
