package Binary_Tree;

public class Kth_ancestor_of_node {
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

    // TC = O(n)
    // SC = O(n) becouse of the recursion of stack
    public static int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        // when the root value beceome n and then return 0 as distance
        if (root.data == n) {
            return 0;
        }
        // to find the left and right distance and where my node exists if its exists in
        // the right side that will give me valied ouput
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // check valied distane
        int max = Math.max(leftDist, rightDist);
        if ((max + 1) == k) {
            System.out.println("ancestor is : " + root.data);
        }

        // return a distance
        return max + 1;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int node = 5;
        int k = 2; // kth ancestor
        System.out.println("distance  : " + kAncestor(root, node, k));

    }
}
