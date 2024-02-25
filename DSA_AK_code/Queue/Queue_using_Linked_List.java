package Queue;

public class Queue_using_Linked_List {
    static class Node {
        // initialization
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class queue {
        static Node head = null;
        static Node tail = null;

        // for empty O(1)
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // O(1)
        public static void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // O(1)
        public static int remove()

        {
            if (isEmpty()) {
                System.out.println("the queue is empty");
                return -1;
            }
            int front = head.data;
            if (tail == head) {
                tail = head = null;
            } else {

                head = head.next;
            }
            return front;
        }

        // O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("the queue is empty");
                return -1;
            }
            int front = head.data;
            return front;
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
