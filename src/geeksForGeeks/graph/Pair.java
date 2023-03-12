package geeksForGeeks.graph;

class Pair {
    int node;
    int weight;
    int parent;
    public Pair(int node, int weight, int parent) {
        this.node = node;
        this.weight = weight;
        this.parent = parent;
    }
    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
        this.weight = parent;
    }
}
//class Pair {
//    int node;
//    int weight;
//
//    public Pair(int node, int weight) {
//        this.node = node;
//
//        this.weight = weight;
//    }
//}