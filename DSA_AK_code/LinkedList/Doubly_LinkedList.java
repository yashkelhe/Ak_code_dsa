package LinkedList;

public class Doubly_LinkedList {

    public class Node {
        int data;
        Node next;
        Node prev;

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addLast(int data) {
        Node tamp = new Node(data);
        size++;
        if (head == null) {
            head = tail = tamp;
        }

        tail.next = tamp;
        tail = tamp;

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data) {
        // first create a new Node
        Node temp = new Node(data);
        size++;
        if (head == null) {
            head = tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    public int removeFirst() {
        Node temp = head;
        if (head == null) {
            head = tail = temp;
            return Integer.MIN_VALUE;
        }
        // if Node has only one element int he ll
        if (head.next == null) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        int data = head.data;
        head = head.next;
        head.prev = null;
        return data;
    }

    public void removeLast() {
        Node temp = head;
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;

    }

    public void reverse() {
        Node curr = head;
        Node next;
        Node pre = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            curr.prev = next;
            pre = curr;
            curr = next;
        }
        head = pre;
    }

    public static void main(String args[]) {
        // create a object
        Doubly_LinkedList dll = new Doubly_LinkedList();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.print();
        dll.addFirst(0);
        dll.addLast(4);
        dll.print();
        System.out.println(dll.size);
        dll.removeFirst();
        dll.removeLast();
        dll.print();

        dll.reverse();
        dll.print();
    }
}
