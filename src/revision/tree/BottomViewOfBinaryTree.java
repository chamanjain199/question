package revision.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> treeMapTreeMap = new TreeMap<>();
        Queue<Taple> queue = new LinkedList<>();
        queue.add(new Taple(0, root));
        while (!queue.isEmpty()) {
            Taple taple = queue.poll();
            Node node = taple.val;
            treeMapTreeMap.put(taple.i, node.data);
            if (node.left != null) {
                queue.add(new Taple(taple.i - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Taple(taple.i + 1, node.right));
            }
        }
        return new ArrayList<>(treeMapTreeMap.values());
    }
}
