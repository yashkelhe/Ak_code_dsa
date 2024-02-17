package LinkedList.question;

public class swaping_Nodes_LL {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void swap(Node head, int x, int y) {
        // first cheack weather x and y are some or not
        if (x == y) {
            return;
        }

        Node prevx = null, currx = head;
        while (currx != null && currx.data == x) {
            prevx = currx;
            currx = currx.next;
        }
        Node prevy = null, curry = head;
        while (curry != null && curry.data == x) {
            prevy = curry;
            curry = curry.next;
        }

        if (currx == null && currx == null) {
            return;
        }
        // for the x
        if (prevx != null) {
            prevx.next = curry;
        } else {
            head = curry;
        }

        // for y
        if (prevy != null) {
            prevy.next = currx;

        } else {
            head = currx;

        }

    }

    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        swaping_Nodes_LL dl = new swaping_Nodes_LL();
        Node head = dl.new Node(1);
        Node newNode = dl.new Node(2);
        head.next = newNode;

        newNode = dl.new Node(3);
        head.next.next = newNode;

        newNode = dl.new Node(4);
        head.next.next.next = newNode;

        newNode = dl.new Node(5);
        head.next.next.next.next = newNode;

        head.next.next.next.next.next = null;
        dl.print(head);
        dl.swap(head, 1, 3);
        dl.print(head);

    }
}
