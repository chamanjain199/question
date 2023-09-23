package revision.tree;

import java.util.*;


public class VerticalTraversalOfBinaryTree {
    static ArrayList<Integer> verticalOrder(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMapTreeMap = new TreeMap<>();
        Queue<Taple> queue = new LinkedList<>();
        queue.add(new Taple(0, 0, root));
        while (!queue.isEmpty()) {
            Taple taple = queue.poll();
            Node node = taple.val;
            if (!treeMapTreeMap.containsKey(taple.i)) {
                treeMapTreeMap.put(taple.i, new TreeMap<>());
            }
            if (treeMapTreeMap.get(taple.i).get(taple.j) == null) {
                treeMapTreeMap.get(taple.i).put(taple.j, new PriorityQueue<>());
            }
            treeMapTreeMap.get(taple.i).get(taple.j).offer(node.data);
            if (node.left != null) {
                queue.add(new Taple(taple.i - 1, taple.j + 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Taple(taple.i + 1, taple.j + 1, node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> tm : treeMapTreeMap.values()) {
            for (PriorityQueue<Integer> pq : tm.values()) {
                while (!pq.isEmpty()) {
                    ans.add(pq.poll());
                }
            }
        }
        return ans;
    }
    static ArrayList<Integer> verticalOrder2(Node root) {
        TreeMap<Integer, LinkedList<Integer>> treeMapTreeMap = new TreeMap<>();
        Queue<Taple> queue = new LinkedList<>();
        queue.add(new Taple(0, 0, root));
        while (!queue.isEmpty()) {
            Taple taple = queue.poll();
            Node node = taple.val;
            if (!treeMapTreeMap.containsKey(taple.i)) {
                treeMapTreeMap.put(taple.i, new LinkedList<>());
            }

            treeMapTreeMap.get(taple.i).add(node.data);
            if (node.left != null) {
                queue.add(new Taple(taple.i - 1, taple.j + 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Taple(taple.i + 1, taple.j + 1, node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (LinkedList<Integer> tm : treeMapTreeMap.values()) {
                while (!tm.isEmpty()) {
                    ans.add(tm.poll());
                }
        }
        return ans;
    }
}
