package Binary_search_tree;

// TC O(h) h= is height
public class Print_In_range {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root, int value) {
        // If the root is null, create a new node with the given value and return it
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // If the value is less than the data in the current node, insert it into the
        // left subtree
        if (root.data > value) {
            // Traverse to the left subtree and insert the value there
            root.left = insert(root.left, value);
        }
        // If the value is greater than the data in the current node, insert it into the
        // right subtree
        else {
            // Traverse to the right subtree and insert the value there
            root.right = insert(root.right, value);
        }
        // Return the modified root of the subtree
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        // case 1

        if (root == null) {
            return;
        }
        if (k1 <= root.data && k2 >= root.data) {
            // frist we go in the left /
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            // then right
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // inorder
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        // l.rt.r
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 5, 2, 1, 3, 4, 7, 9, 10, 8, 6 };
        Node root = null;
        int key = 11;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        printInRange(root, 5, 12);
    }
}
