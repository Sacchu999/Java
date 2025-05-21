package DSA.linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printHead() {
        System.out.println("Head : " + head.value);
    }

    public void printTail() {
        System.out.println("Tail : " + tail.value);
    }

    public void printLength() {
        System.out.println("Length : " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
}
