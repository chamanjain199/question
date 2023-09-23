package revision.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    int capacity;
    public Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void addToFront(Node val) {
        val.prev = head;
        val.next = head.next;
        head.next.prev = val;
        head.next = val;
    }

    private void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToFront(Node node) {
        if (node != head) {
            delete(node);
            addToFront(node);
        }

    }


    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveToFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToFront(node);
        } else {
            Node newNode = new Node(key,value);
            cache.put(key, newNode);
            if (cache.size() > capacity) {
                cache.remove(tail.prev.key);
                delete(tail.prev);
            }
            addToFront(newNode);
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));


    }
}
