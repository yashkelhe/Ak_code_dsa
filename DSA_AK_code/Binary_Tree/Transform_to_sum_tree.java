package Binary_Tree;

public class Transform_to_sum_tree {

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

    public static int toSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftchild = toSumTree(root.left);
        int rightchild = toSumTree(root.right);

        // both when null
        int data = root.data;
        // just rather then sending the null send 0

        int newLeft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        // left and right
        // we want a hole sum of the tree
        root.data = newLeft + leftchild + newright + rightchild;
        // to add to upper level
        return data;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        // root left right
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        toSumTree(root);
        preorder(root);
    }
}
