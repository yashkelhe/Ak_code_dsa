package DSA_AK_code.Binary_Tree.question;

TC is O(n);SC is O(n);
public class Delete_all_leaf_Node_has_x_value {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node deleteLeafNode(Node root, int x) {
        if (root == null) {
            return null;
        }

        // The placement of the condition if (root.left == null && root.right == null &&
        // root.data == x) is essential for the correct functioning of the algorithm.
        // Placing it below the recursive calls ensures that we traverse the entire
        // subtree before checking if the current node meets the conditions for
        // deletion.

        // If we were to put this condition above the recursive calls, it would result
        // in premature termination of the traversal whenever a node with value x is
        // encountered. This would prevent us from properly traversing and deleting leaf
        // nodes in the subtree.
        root.left = deleteLeafNode(root.left, x);
        root.right = deleteLeafNode(root.right, x);
        if (root.data == x && root.left == null && root.right == null) {
            return null;
        }
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
        root.left.left = new Node(3);
        root.left.right = new Node(3);
        root.right.left = new Node(3);
        root.right.right = new Node(3);
        int x = 3;
        inOrder(root);
        System.out.println();
        deleteLeafNode(root, x);
        inOrder(root);

    }
}

// root.left = deleteLeafNode(root.left, x);
// root.right = deleteLeafNode(root.right, x);
// These lines are necessary to update the left and right subtrees of the
// current node root. When we make a recursive call, it might modify the left
// and/or right subtrees of the current node. Therefore, after the recursive
// calls return, we need to assign the updated subtrees back to the current
// node's left and right pointers.