package LinkedList;

// Finding the middle: O(n)
// Reversing the second half: O(n)
// Zig-zag rearrangement: O(n)
// When we add these complexities together, we get O(n + n + n) = O(3n). However, in Big O notation, we drop the constant factor, so the overall time complexity of the provided code is O(n).

// 1->2->3->4->5->6->null
// 1->6->2->5->3->4->null
public class Zig_zag {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addLast(int value) {
        Node temp = new Node(value);
        if (head == null) {
            head = tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public void zigZag() {
        // to find the Mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }

        Node mid = slow;

        // reverse 2nd half
        // three variable and four steps

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (right != null && left != null) {
            // zig zag
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // update ,next Node
            left = nextL;
            right = nextR;
        }

    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Zig_zag ll = new Zig_zag();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printLL();
        ll.zigZag();
        ll.printLL();

    }
}
