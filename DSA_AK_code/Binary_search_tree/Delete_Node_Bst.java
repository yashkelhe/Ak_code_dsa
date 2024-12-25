package Binary_search_tree;

public class Delete_Node_Bst {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;

        }
    }

    public static Node findInOrderSuccessor(Node root) {
        // to find the right tree smallest which is successor
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        // if small then left else right
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        }
        // when you find the Node
        else {

            // case 1
            // when the left and right node is null then that node is leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            // when the only left node is null or right node is null
            // only one side is preset
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            // here the node is present in the middle somewhere
            // first find the successor

            // what does say is
            // left most Node in right subtree; minimum in right subtree
            Node is = findInOrderSuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        // l.rt.r
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
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

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        root = delete(root, 5);
        System.out.println();

        inOrder(root);

    }

}

// //////////////////////////// deleteFunction///////////////////
/*
 * Function Explanation:
 * Base Case:
 * 
 * If the root is null, there's nothing to delete, so return null.
 * Traverse the Tree:
 * 
 * If the value to delete (val) is less than root.data, the node must be in the
 * left subtree. Recurse into the left subtree: root.left = delete(root.left,
 * val).
 * If the value is greater than root.data, recurse into the right subtree:
 * root.right = delete(root.right, val).
 * Node Found:
 * 
 * If root.data == val, we need to delete this node. Three cases are handled
 * here:
 * Case 1: Node is a Leaf
 * If both root.left and root.right are null, simply return null to remove this
 * node.
 * Case 2: Node has One Child
 * If the node has only one child:
 * If root.left == null, return root.right. This "replaces" the node with its
 * right child.
 * If root.right == null, return root.left. This "replaces" the node with its
 * left child.
 * Case 3: Node has Two Children
 * Find the In-Order Successor:
 * The in-order successor is the smallest node in the right subtree (leftmost
 * node in the right subtree).
 * Call findInOrderSuccessor(root.right) to get this node.
 * Replace Current Node's Value:
 * Set root.data to the value of the in-order successor (is.data).
 * Delete the In-Order Successor:
 * Recursively delete the in-order successor from the right subtree: root.right
 * = delete(root.right, is.data).
 * Return the Updated Root:
 * 
 * After handling the deletion, return the updated root node.
 * 
 * 
 */