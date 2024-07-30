package LinkedList;

// and time complexity of this code is O(n Logn )
public class MergeSort_LL {
   public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
        System.out.println();
    }
    // creating linked List
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

    public Node mergeSort(Node head) {
        // base case
        // when list empty or has one node then it is already a sorted list
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left & right
        Node rightNode = mid.next;
        mid.next = null;
        Node newLeftNode = mergeSort(head);
        Node newRightNode = mergeSort(rightNode);

        return merge(newLeftNode, newRightNode);

    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow; // mid Node

    }

    private Node merge(Node head1, Node head2) {
        // intialize the node 
        Node mergeLL = new Node(-1);
        // assign a iterator 
        Node temp = mergeLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                // next element 
                head1 = head1.next;
            } else {
                temp.next = head2;
                // next element 
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // If any elements are remaining in either of the lists
        // lets consider on of the linkedList is samll 
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

 

    public static void main(String[] args) {
        MergeSort_LL ll = new MergeSort_LL();
        ll.head = new Node(4);
        ll.head.next = new Node(9);
        ll.head.next.next = new Node(8);
        ll.head.next.next.next = new Node(7);
        ll.head.next.next.next.next = new Node(3);
        ll.head.next.next.next.next.next = new Node(5);

        // Now we have to sort this LinkedList in ascending order
        ll.print(head);
        ll.head = ll.mergeSort(ll.head);

        // Print the sorted LinkedList
        Node temp = ll.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
