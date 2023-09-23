package revision.tree;

public class MirrorTree {
    void mirror(Node node) {
        if(node!=null){
            Node left=node.left;
            Node right=node.right;
            node.left=right;
            node.right=left;
            mirror(node.left);
            mirror(node.right);
        }
    }
}
