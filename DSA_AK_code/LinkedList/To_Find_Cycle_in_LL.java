package LinkedList;

public class To_Find_Cycle_in_LL {

    // this is node class which will used to create new Node

    // and this also called as the Floyd's algorithm
    // and O(N) will be the time compelxity
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

    public Boolean isCycle() {
        Node slow = head;
        Node Fast = head;
        while (Fast != null && Fast.next != null) {
            slow = slow.next;// +1
            Fast = Fast.next.next;// +2
            if (slow == Fast) {
                return true; // cycle exists
            }

        }
        return false;// cycle doesn't exists
    }

    public void removeLoop() {

        // Detect cycle
        Node slow = head;
        Node Fast = head;

        Boolean cycle = false;
        while (Fast != null && Fast.next != null) {
            slow = slow.next;
            Fast = Fast.next.next;
            if (slow == Fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // find metting point
        slow = head;
        Node prev = null;
        while (slow != Fast) {
            prev = Fast;
            slow = slow.next;
            Fast = Fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;

    }

    public static void main(String[] args) {
        To_Find_Cycle_in_LL ll = new To_Find_Cycle_in_LL(); // create a object
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next = head;
        // 1 - 2 - 3- 2

        // System.out.println(ll.isCycle());
        ll.removeLoop();
    }
}
