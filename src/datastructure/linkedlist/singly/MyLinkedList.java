package datastructure.linkedlist.singly;

public class MyLinkedList {
    Node head;
    Node tail;
    int size = 0;

    public MyLinkedList() {

    }

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
        Node temp = head;
        int idx = 0;
        while (idx < index) {
            idx++;
            temp = temp.next;
        }

        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
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
            Node temp = head;
            int idx = 1;
            while (idx < index) {
                idx++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }


    }

    public void deleteAtIndex(int index) {
        if (index >= size || size == 0) {
            return;
        }
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        } else {
            Node temp = head;
            int idx = 1;
            while (idx < index) {
                idx++;
                temp = temp.next;
            }
            Node t = temp.next;
            temp.next = null;
            if(t!=null){
                temp.next=t.next;
            }
            if (index == (size - 1)) {
                tail = temp;
            }
        }
        size--;
    }
}
