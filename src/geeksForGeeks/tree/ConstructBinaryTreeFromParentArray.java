package geeksForGeeks.tree;

import java.util.*;

public class ConstructBinaryTreeFromParentArray {
    public static Node createTree(int parent[], int N) {
        Node parentNode = null;
        List<int[]> l = new ArrayList<>();

        HashMap<Integer, Node> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hashMap.put(i, new Node(i));
        }
        for (int i = 0; i < N; i++) {
            int parentNodeValue = parent[i];
            if (parentNodeValue == -1) {
                parentNode = hashMap.get(i);
            } else {
                Node cureNode = hashMap.get(parent[i]);
                if (cureNode.left == null) {
                    cureNode.left = hashMap.get(i);
                } else {
                    cureNode.right = hashMap.get(i);
                }
            }
        }
        return parentNode;
    }

    public static void main(String[] args) {

    }
}
