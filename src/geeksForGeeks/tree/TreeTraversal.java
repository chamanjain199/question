package geeksForGeeks.tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeTraversal {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // inorderTraversalRecursion(root);
        inorderTraversalIterative(root);
        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // preorderTraversalRecursion(root);
        preorderTraversalIterative(root);
        return ans;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        // postorderTraversalRecursion(root);
        postorderTraversalIterative(root);
        return ans;
    }

    private void inorderTraversalRecursion(TreeNode node) {
        if (node != null) {
            inorderTraversalRecursion(node.left);
            ans.add(node.val);
            inorderTraversalRecursion(node.right);
        }
    }

    private void preorderTraversalRecursion(TreeNode node) {
        if (node != null) {
            ans.add(node.val);
            preorderTraversalRecursion(node.left);
            preorderTraversalRecursion(node.right);
        }
    }

    private void postorderTraversalRecursion(TreeNode node) {
        if (node != null) {
            postorderTraversalRecursion(node.left);
            postorderTraversalRecursion(node.right);
            ans.add(node.val);
        }
    }

    private void inorderTraversalIterative(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = node;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    private void preorderTraversalIterative(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = node;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    ans.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    cur = cur.right;
                }
            }
        }
    }

    private void postorderTraversalIterative(TreeNode node) {
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = node;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    if (cur.val > 0) {
                        cur.val = -cur.val;
                        stack.add(cur);
                        cur = cur.right;
                    } else {
                        cur.val = -cur.val;
                        ans.add(cur.val);
                        cur = null;
                    }
                }
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(new Pair(root, 0, 0));
        Pair current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            int x = current.row;
            int y = current.col;
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(current.val2.val);

            if (current.val2.left != null) {
                queue.add(new Pair(current.val2.left, x - 1, y + 1));
            }
            if (current.val2.right != null) {
                queue.add(new Pair(current.val2.right, x + 1, y + 1));
            }
        }
        map.forEach((key, value) -> {
            List<Integer> newList = new ArrayList<>();
            value.forEach((ikey, ivalue) -> {
                while (!ivalue.isEmpty())
                    newList.add(ivalue.poll());
            });
            ans.add(newList);
        });
        return ans;
    }

    public List<List<Integer>> levelOrderTraversalWithLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int sizeOfCurLevel = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < sizeOfCurLevel; i++) {
                TreeNode cur = queue.poll();
                levelList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ans.add(levelList);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(treeTraversal.verticalTraversal(root));
    }

}
