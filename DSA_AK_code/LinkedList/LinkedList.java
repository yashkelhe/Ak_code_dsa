package LinkedList;

public class LinkedList {
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
    public static int size = 0;

    // add first node
    public void addFirst(int data) {
        // create a new node
        Node newNode = new Node(data);
        size++;
        // when head is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 to newNod next = head
        newNode.next = head;
        // step 3 head = newNode
        head = newNode;
    }

    // add in last
    public void addLast(int data) {
        // create a new node
        Node newNode = new Node(data);
        size++;
        // special case is when head node is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // to assign tail next to the newNode
        tail.next = newNode;
        // and last assign tail value to the newNode
        tail = newNode;
    }

    // and TC is O(n)
    public void print() {
        if (head == null) {
            System.out.println("list is empty ");
            return;
        }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NUll");
    }

    // add in the middle TC(n)
    public void addMiddle(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove at first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("linkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove at last
    public int removeLast() {
        if (size == 0) {
            System.out.println("linkedlist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        // previouse= size -2 ;
        Node pre = head;
        for (int i = 0; i < size - 2; i++) {
            pre = pre.next; // prev is pointing to the next node so will we go up to size -2
        }
        int val = pre.next.data;// tail.data
        pre.next = null;
        size--;
        tail = pre;
        return val;

    }

    // search
    public int search(int key) {
        // using iterative search TC O(n);
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // recursive search
    // here what we are doing is when are cheacking the each head is equal to the
    // key or not by sending the head.next linked list and base case will be when
    // recursive call reaches to the end then head.next will be equal to the null
    // then just return if we dont found key in the list then it will return -1 and
    // when it bactracking at that time we just add one so it will also give me the
    // index of the found key

    // and time complexty is O(n);
    // space complexty is also O(n);
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        if (index == -1) {
            System.out.println("key is not found");
            return -1;
        }
        return index + 1;
    }

    public int reSearch(int key) {
        return helper(head, key);
    }

    // reverse the LinkedList
    // here we will use the three nodes to reveres the linkedList
    // first is prev
    // curr
    // next
    // TC O(n)
    public void reverse() {
        Node pre = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // here becouse curr is become a null so prev of the curr is will be the head
        head = pre;
    }

    // delete from back
    public void deleteFromBack(int n) {
        // formula is to get the index is
        // size -n
        int si = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            si++;
        }

        if (n > si) {
            System.out.println("please enter a correct index");
            return;
        }
        if (n == si) {
            head = head.next; // remove first element when you see that the linked list size is 5 and i want
                              // to delete the 5 element from the back it means that we have to delete the
                              // first node so that will be our head
            return;
        }

        int indOf = si - n;
        int i = 0;
        Node prev = head;
        while (i < indOf) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

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

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.print();
        l1.addFirst(2);
        l1.addFirst(2);
        l1.addFirst(2);
        l1.addFirst(2);

        l1.print();
        l1.addFirst(1);
        l1.print();
        l1.addLast(3);
        l1.print();
        l1.addMiddle(2, 4);
        l1.print();
        System.out.println("remove value is at head Index : " + l1.removeFirst());
        l1.print();
        System.out.println("and size of the linkedList : " + l1.size);
        System.out.println(l1.removeLast());
        l1.print();
        System.out.println("using iteration method :" + l1.search(4));
        System.out.println("using recursive method : " + l1.reSearch(2));

        l1.reverse();
        l1.print();

        l1.deleteFromBack(3);
        l1.print();
        System.out.println("the list is palindrom : " + l1.cheackPalindrom());
    }

}
