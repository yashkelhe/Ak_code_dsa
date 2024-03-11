package Binary_Tree;

public class height_tree {
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

    public static int Height(Node root) {
        if (root == null) {
            return 0;
        }
        // assum that the if the any root does not have the left node the it will give
        // you the 0 else present the 1 like that left and reight height will come and
        // the we will take maximum one for the root height

        int lh = Height(root.left);
        int rh = Height(root.right);
        int count = Math.max(lh, rh) + 1;
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(Height(root));

    }
}
