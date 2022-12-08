package geeksForGeeks.linkedList;

import java.util.HashMap;
import java.util.Map;


public class LRUCatch2 {
    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> catchMap;

    LRUCatch2(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        catchMap = new HashMap<>();
    }

    private void addAtHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void moveToFront(Node value) {
        if (value != head) {
            deleteNode(value);
            addAtHead(value);
        }
    }

    public int get(int key) {
        Node value = catchMap.get(key);
        if (value == null) {
            return -1;
        }
        moveToFront(value);
        return value.value;
    }



    public void put(int key, int value) {
        Node nodeValue = catchMap.get(key);
        if (nodeValue != null) {
            nodeValue.value = value;
            moveToFront(nodeValue);
        } else {
            nodeValue = new Node(key, value);
            catchMap.put(key,nodeValue);
            if (size < capacity) {
                size++;
            } else {
                catchMap.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            addAtHead(nodeValue);
        }
    }
}
