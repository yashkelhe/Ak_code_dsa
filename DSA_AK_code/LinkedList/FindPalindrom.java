package LinkedList;

public class FindPalindrom {
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

    // here we are using the slow fast meythod to find the Mid value for both even
    // and odd Nodes
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }

        return slow;
    }

    public Boolean cheackPalindrom() {
        if (head == null || head.next == null) {
            return true;
        }
        // step1 find the mid
        Node midNode = findMid(head);

        // step2 is to reverse the second half part
        Node pre = null;
        Node curr = midNode;
        Node next;

        while (curr.next != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        Node right = pre;// here we are taling the reverse of the first node
        Node left = head;
        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public void addLast(int val) {
        Node newDat = new Node(val);
        if (head == null) {
            head = tail = newDat;
            return;
        }
        tail.next = newDat;
        tail = newDat;
        return;

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        FindPalindrom ww = new FindPalindrom();
        ww.addLast(1);
        ww.addLast(2);
        ww.addLast(2);
        ww.addLast(1);
        // ww.print();
        System.out.println(ww.cheackPalindrom());
    }
}
