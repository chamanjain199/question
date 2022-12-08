package geeksForGeeks.linkedList;

import java.util.HashMap;
import java.util.Map;
//Not optimized
class LRUCache {
    int capacity;
    int size = 0;
    Node head;
    Node tail;
    Map<Integer, Node> catchMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public void deleteNode(Node v) {
        if (v == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            v.prev.next = v.next;
            v.next.prev = v.prev;
        }

    }

    public void addAtHead(Node v) {
        if (head == null) {
            head = v;
            tail = v;
        } else {
            v.next = head;
            head.prev = v;
            head = v;
            v.prev = null;
        }

    }


    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        Node value = catchMap.get(key);
        if (value != null) {
            if (value != head) {
                deleteNode(value);
                addAtHead(value);
            }
            return value.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        Node oldVal = catchMap.get(key);
        if (oldVal != null) {
            oldVal.value = value;
            newNode = oldVal;
        } else {
            catchMap.put(key, newNode);
        }
        if (oldVal == null && size == capacity) {
            catchMap.remove(tail.key);
        }
        if (size == 0) {
            addAtHead(newNode);
            size++;
        } else if (key != head.key) {
            if (oldVal != null) {
                deleteNode(oldVal);
            }
            if (size < capacity) {
                addAtHead(newNode);
                if (oldVal == null) {
                    size++;
                }
            } else if (size == capacity) {
                if (size == 1) {
                    head = newNode;
                    tail = newNode;
                } else {
                    if (oldVal == null) {
                        deleteNode(tail);
                    }
                    addAtHead(newNode);
                }
            }
        } else {
            head.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);
        lRUCache.get(2);
        lRUCache.put(1, 1);
        lRUCache.put(4, 1);
        lRUCache.get(2);

    }
}