package LinkedList.question;

// In a system, there are two singly linked lists. By some programming error, the end node of one of the linked lists got linked to the second list, forming an inverted Y-shaped list. Write a program to get the point where two linked lists merge.
public class find_y_point {

    // the time complexity of this code is that a O(n* m ) becous we are usinf two
    // while loop and each is going up to n elements
    // TC O(1);
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public Node getTheInterSectionPoint(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        find_y_point y = new find_y_point();

        Node head1, head2;
        head1 = y.new Node(4);
        head2 = y.new Node(1);

        Node newNode = y.new Node(2);
        head2.next = newNode;

        newNode = y.new Node(3);
        head2.next.next = newNode;

        newNode = y.new Node(5);
        head1.next = newNode;

        newNode = y.new Node(6);
        head1.next.next = newNode;
        head2.next.next.next = newNode;

        newNode = y.new Node(7);
        head1.next.next.next = newNode;

        head1.next.next.next.next = null;

        Node interesectionPoint = y.getTheInterSectionPoint(head1, head2);

        if (interesectionPoint == null) {
            System.out.println("List does not contain the intersection point");
        } else {
            System.out.println("the intersection point is :" + interesectionPoint.data);
        }

    }
}
