package DSA_AK_code.Binary_search_tree;

// TC O(h) h= is height
public class Search_BST {

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

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            // here search will return the answer as true or false
            return search(root.left, key);
        } else {
            return search(root.right, key);
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
        System.out.println(search(root, key));
    }
}
