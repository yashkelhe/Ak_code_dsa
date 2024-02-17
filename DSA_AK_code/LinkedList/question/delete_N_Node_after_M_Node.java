package LinkedList.question;

public class delete_N_Node_after_M_Node {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public Node head;

    // same but littile ootimize O(n)
    public void skipMdeleteN(Node head, int M, int N) {
        Node curr = head, t;
        int count;

        while (curr != null) {
            // Skip M nodes
            for (count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }

            if (curr == null)
                return;

            // Delete N nodes
            t = curr.next;
            for (count = 1; count <= N && t != null; count++) {
                Node temp = t;
                t = t.next;
            }

            // Update pointers
            curr.next = t;
            curr = t;
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
        delete_N_Node_after_M_Node dl = new delete_N_Node_after_M_Node();
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
        dl.skipMdeleteN(head, 2, 2);
        // dl.print(head);
        dl.print(head);
    }
}
