package geeksForGeeks.linkedList;

class Data {
    int key;
    int value;

    Data(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Node {
    int data;
    Node next;
    Node bottom;
    Node arb;
    Node random;

    Node prev;
    int key;
    int value;

    Data obj;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(Data data) {
        this.obj = data;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}