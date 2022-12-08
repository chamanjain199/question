package geeksForGeeks.tree;

public class Pair {
    int key;

    int col;
    int row;
    Node val;
    TreeNode val2;

    public Pair(Node val, int key) {
        this.key = key;
        this.val = val;
    }

    public Pair(TreeNode val, int key) {
        this.key = key;
        this.val2 = val;
    }

    public Pair(TreeNode val, int row, int col) {
        this.col = col;
        this.row = row;
        this.val2 = val;
    }
}
