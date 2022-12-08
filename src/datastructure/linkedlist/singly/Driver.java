package datastructure.linkedlist.singly;

public class Driver {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(1,2);
        System.out.println( myLinkedList.get(1));
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(2);
        System.out.println( myLinkedList.get(3));
        myLinkedList.addAtTail(1);
        System.out.println( myLinkedList.get(5));
        myLinkedList.addAtHead(2);
        System.out.println( myLinkedList.get(2));
        myLinkedList.addAtHead(6);
        myLinkedList.print();


    }
}
