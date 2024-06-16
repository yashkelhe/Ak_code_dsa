package Binary_search_tree.question;

public class sum_of_Range_Node {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int counter = 0;

    public static void preOrder(Node root, int l, int r) {
        if (root == null) {
            return;
        }
        if (root.data >= l && root.data <= r) {
            counter += root.data;
        }
        if (root.data > l) {
            preOrder(root.left, l, r);
        }
        if (root.data < r) {
            preOrder(root.right, l, r);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
        int l = 2;
        int r = 7;
        preOrder(root, l, r);
        System.out.println("the sum is : " + counter);
    }
}
