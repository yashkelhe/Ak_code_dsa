package LinkedList;

public class To_Find_Cycle_in_LL {

    // Node class used to create a new Node
    // This implementation uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Method to detect cycle in the linked list
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        
        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2

            // If the slow and fast pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }
        // If we reach the end of the list, no cycle exists
        return false;
    }

    // Method to remove cycle from the linked list
    public void removeLoop() {
        // Detect cycle using two pointers
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2

            // If the slow and fast pointers meet, a cycle exists
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        // If no cycle is found, return
        if (!cycle) {
            return;
        }

        // Find the starting point of the cycle
        slow = head;
        Node prev = null;

        // . When slow and fast meet again, they will be at the start of the cycle.
        while (slow != fast) {   
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the cycle by setting the previous node's next to null
        prev.next = null;
    }

    // Method to add nodes to the list for testing
    public void addNode(int data) {
        Node newNode = new Node(data);

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, find the last node and add the new node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void main(String[] args) {
        To_Find_Cycle_in_LL ll = new To_Find_Cycle_in_LL();
        ll.addNode(1);
        ll.addNode(2);
        ll.addNode(3);

        // Creating a cycle manually for testing
        // This creates a cycle: 1 -> 2 -> 3 -> 2 ...
        ll.head.next.next.next = ll.head.next;

        // Check if a cycle is detected
        System.out.println("Cycle detected: " + ll.isCycle()); // Should print true

        // Remove the cycle if it exists
        ll.removeLoop();

        // Check again if a cycle is detected after removal
        System.out.println("Cycle detected after removal: " + ll.isCycle()); // Should print false
    }
}
