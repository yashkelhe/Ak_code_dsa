package question;

public class Univalued_tree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // time complexity of the code is O(n);
    // space complexity of the code is if we considerd the stack O(n)
    // if we dident considerd the stack then O(1)

    public static boolean univaluedTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.right != null && root.right.data != root.data) {
            return false;
        }
        if (root.left != null && root.left.data != root.data) {
            return false;
        }

        boolean lf = univaluedTree(root.left);
        boolean rt = univaluedTree(root.right);

        return lf && rt;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.left = new Node(1);
        root.right.right = new Node(2);

        if (univaluedTree(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}