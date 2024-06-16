package Binary_search_tree;

// it take TC O(n)
public class Mirror_BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    
    // inorder
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        // l.rt.r
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        inorder(root);
        mirror(root);
        System.out.println();
        inorder(root);

    }
}
