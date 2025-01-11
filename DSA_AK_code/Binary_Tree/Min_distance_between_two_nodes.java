package Binary_Tree;

public class Min_distance_between_two_nodes {
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

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }
        // first check that the root is matcing or not
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // check where n1 or n2 exists
        Node leftNode = lca2(root.left, n1, n2);
        Node rightNode = lca2(root.right, n1, n2);

        // if only exists on the left
        // left = val ; right = null
        if (rightNode == null) {
            return leftNode;
        }
        // if the only exists on the right
        // left = null; right = val
        if (leftNode == null) {
            return rightNode;
        }

        // if the nodes exists in the both side then just return root beceouse the
        // common is our root between left and right
        return root;
    }

    public static int lcadist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        }

        else if (leftdist == -1) {
            return rightdist + 1;
        } else {
            return leftdist + 1;
        }
    }

    public static int minDis(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcadist(lca, n1);
        int dist2 = lcadist(lca, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4, n2 = 6;
        System.out.println(minDis(root, n1, n2));

    }
}

/*
 * Distance from LCA (1) to Node 4
 * Call 1: lcadist(root = 1, n = 4)
 * 
 * root.data = 1, not equal to 4.
 * Recursively check left and right subtrees.
 * Call 2: lcadist(root = 2, n = 4) (left subtree of 1)
 * 
 * root.data = 2, not equal to 4.
 * Recursively check left and right subtrees.
 * Call 3: lcadist(root = 4, n = 4) (left subtree of 2)
 * 
 * root.data = 4, matches n = 4.
 * Return 0.
 * Back to Call 2:
 * 
 * leftdist = 0 (from Call 3).
 * rightdist = -1 (no match in the right subtree).
 * Return leftdist + 1 = 1.
 * Back to Call 1:
 * 
 * leftdist = 1 (from Call 2).
 * rightdist = -1 (no match in the right subtree).
 * Return leftdist + 1 = 2.
 * Distance from Node 1 to Node 4 = 2
 * 
 * Distance from LCA (1) to Node 6
 * Call 1: lcadist(root = 1, n = 6)
 * 
 * root.data = 1, not equal to 6.
 * Recursively check left and right subtrees.
 * Call 2: lcadist(root = 3, n = 6) (right subtree of 1)
 * 
 * root.data = 3, not equal to 6.
 * Recursively check left and right subtrees.
 * Call 3: lcadist(root = 6, n = 6) (left subtree of 3)
 * 
 * root.data = 6, matches n = 6.
 * Return 0.
 * Back to Call 2:
 * 
 * leftdist = 0 (from Call 3).
 * rightdist = -1 (no match in the right subtree).
 * Return leftdist + 1 = 1.
 * Back to Call 1:
 * 
 * leftdist = -1 (no match in the left subtree).
 * rightdist = 1 (from Call 2).
 * Return rightdist + 1 = 2.
 * Distance from Node 1 to Node 6 = 2
 * 
 * 
 */