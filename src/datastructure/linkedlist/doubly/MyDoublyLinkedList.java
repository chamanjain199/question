package datastructure.linkedlist.doubly;

import leetcode.daily.challenge.NonDecreasingArray;

public class MyDoublyLinkedList {
    public Node head;
    public Node tail;
    public int size = 0;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        if (index == (size - 1)) {
            return tail.val;
        }
        Node temp = head;
        while (index > 0) {
            index--;
            temp = temp.next;
        }

        return temp.val;
    }

    public void deleteByValue(int val) {
        if (size == 0) {
            return;
        }
        Node temp = head;

        while (temp != null && temp.val != val) {
            temp = temp.next;

        }
        if (temp == null) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (temp == head) {
            temp = temp.next;
            temp.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node prev = temp.prev;
            Node next = temp.next;
            prev.next = next;
            next.prev = prev;
        }
    }


    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }


    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node nextNode = head;
            while (index > 0) {
                index--;
                nextNode = nextNode.next;
            }
            Node prev = nextNode.prev;
            prev.next = newNode;
            newNode.prev = prev;
            nextNode.prev = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    public void deleteAtTail(int index) {
        if (index >= size || size == 0 || index < 0) {
            return;
        }
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (index == (size - 1)) {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || size == 0 || index < 0) {
            return;
        }
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (index == (size - 1)) {
            tail = tail.prev;
            tail.next = null;
        } else {
            int half = size / 2;
            if (index <= half) {
                Node nodeToBeDeleted = head;
                while (index > 0) {
                    index--;
                    nodeToBeDeleted = nodeToBeDeleted.next;
                }
                Node prev = nodeToBeDeleted.prev;
                prev.next = nodeToBeDeleted.next;
                nodeToBeDeleted.next.prev = prev;
            } else {
                Node nodeToBeDeleted = tail;
                index = size - index - 1;
                while (index > 0) {
                    index--;
                    nodeToBeDeleted = nodeToBeDeleted.prev;
                }
                Node prev = nodeToBeDeleted.prev;
                prev.next = nodeToBeDeleted.next;
                nodeToBeDeleted.next.prev = prev;
            }
        }
        size--;
    }
}
