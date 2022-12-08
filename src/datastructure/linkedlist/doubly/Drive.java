package datastructure.linkedlist.doubly;

public class Drive {
    public static void main(String[] args) {
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
        doublyLinkedList.addAtHead(1);
        doublyLinkedList.addAtTail(3);
        doublyLinkedList.addAtIndex(1, 2);
        doublyLinkedList.get(1);
        doublyLinkedList.deleteAtIndex(1);
        doublyLinkedList.get(1);
    }
}
