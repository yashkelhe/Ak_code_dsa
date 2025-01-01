package LinkedList;

// delete and search the  N

public class DeleteNthFromEnd {
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

    public void deleteFromBack(int n) {
        // formula is to get the index is
        // size -n
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (n == size) {
            head = head.next;
            // remove first element when you see that the linked list size is 5 and i want
            // to delete the 5 element from the back it means that we have to delete the
            // first node so that will be our head
            return;
        }

        // take the number of the index
        int indOf = size - n;
        int i = 0;
        Node prev = head;
        while (i < indOf) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    public static void main(String[] args) {
        DeleteNthFromEnd ll = new DeleteNthFromEnd();
        ll.deleteFromBack(3);
    }
}
