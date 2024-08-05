package question;

public class Invert_Binary_tree {

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

    public static Node invertBinaryTree(Node root) {
        // we have to return the mirrir tree
        if (root == null) {
            return root;

        }
        Node left = invertBinaryTree(root.left);
        Node right = invertBinaryTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inOrder(root);
        System.out.println();
        invertBinaryTree(root);
        System.out.println();
        inOrder(root);
    }
}

1 - 2 3          // Processing left subtree of 1
2 - 4 5          // Processing left subtree of 2
4 - null         // Leftmost leaf, returns null
5 - null         // Right leaf, returns null
2 - null         // After processing left subtree, returns null
3 - 6 7          // Processing right subtree of 3
6 - null         // Left leaf, returns null
7 - null         // Rightmost leaf, returns null
3 - null         // After processing right subtree, returns null
1 - null         // After processing root, returns null
