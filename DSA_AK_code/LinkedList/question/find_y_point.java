package LinkedList.question;

// In a system, there are two singly linked lists. By some programming error, the end node of one of the linked lists got linked to the second list, forming an inverted Y-shaped list. Write a program to get the point where two linked lists merge.
public class find_y_point {

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

    // Function to get the length of the linked list
    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Function to find the intersection point of two linked lists
    public Node getIntersectionPoint(Node head1, Node head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        // Align head1 and head2 to the same starting point relative to the end
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                head2 = head2.next;
            }
        }

        // Traverse both lists together until we find the intersection point
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null; // No intersection point found
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

        Node intersectionPoint = y.getIntersectionPoint(head1, head2);
        
        if (intersectionPoint == null) {
            System.out.println("List does not contain the intersection point");
        } else {
            System.out.println("The intersection point is: " + intersectionPoint.data);
        }
    }
}
