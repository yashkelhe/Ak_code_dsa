package Binary_search_tree;

import java.util.*;

// this also take the TC O(n +n) =O(2n) => O(n) 
public class Convert_BST_to_Balanced_BST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    // inorder
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        // l.rt.r
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static void printPreorder(Node root) {
        if (root == null) {
            return;
        }
        // l.rt.r
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        // int mid = (start + end - start) / 2;

        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);

        return root;

    }

    public static Node balanceBST(Node root) {
        // get the sorted sequence
        if (root == null) {
            return null;
        }
        ArrayList<Integer> inorder = new ArrayList<>();
        // inorder will give u the sorted element
        getInorder(root, inorder);

        // and then create a balacne BST
        Node root1 = createBST(inorder, 0, inorder.size() - 1);

        return root1;
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        printPreorder(root);
        Node root1 = balanceBST(root);
        System.out.println();
        printPreorder(root1);

    }
}
