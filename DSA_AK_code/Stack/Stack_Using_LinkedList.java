package Stack;

public class Stack_Using_LinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // lnikedList head is top for the stack
    static class stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int val) {
            Node newNode = new Node(val);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }
    }

    public static void main(String[] args) {
        // instance or object;
        stack sk = new stack();

        sk.push(3);
        sk.push(2);
        sk.push(1);

        while (!sk.isEmpty()) {
            System.out.println(sk.peek());
            sk.pop();
        }
    }
}
