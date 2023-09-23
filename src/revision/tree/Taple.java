package revision.tree;

class Taple {
    int i;
    int j;
    Node val;

    public Taple(int i, int j, Node val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
    public Taple(int i, Node val) {
        this.i = i;
        this.val = val;
    }
}