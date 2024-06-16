package DSA_AK_code.Binary_search_tree;

import java.util.*;

public class Root_to_leaf_path {

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

    public static void rootToleafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        // when you reach to the leaf node
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        // backtrack
        rootToleafPath(root.left, path);
        rootToleafPath(root.right, path);
        // assume that the left and right values will be remove and only root will be in
        // the arrayList
        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        System.out.println();
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        rootToleafPath(root, list);

    }
}
