package Binary_search_tree;

import java.util.*;

// it takes an linear time O(n);
public class Merge_Two_BST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void getInOrder(Node root, ArrayList<Integer> sortedArray) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, sortedArray);
        sortedArray.add(root.data);
        getInOrder(root.right, sortedArray);
    }

    public static Node balancedTree(ArrayList<Integer> arr, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        // preOrder to create new Tree
        Node root = new Node(arr.get(mid));
        root.left = balancedTree(arr, st, mid - 1);
        root.right = balancedTree(arr, mid + 1, end);
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static Node merge(Node root1, Node root2) {
        ArrayList<Integer> rt1 = new ArrayList<Integer>();
        ArrayList<Integer> rt2 = new ArrayList<Integer>();

        getInOrder(root1, rt1);
        getInOrder(root2, rt2);
        int i = 0, j = 0;

        ArrayList<Integer> finalList = new ArrayList<>();
        while (i < rt1.size() && j < rt2.size()) {
            if (rt1.get(i) <= rt2.get(j)) {
                finalList.add(rt1.get(i));
                i++;
            } else {
                finalList.add(rt2.get(j));
                j++;
            }
        }

        // for security
        while (j < rt2.size()) {
            finalList.add(rt2.get(j));
            j++;
        }
        while (i < rt1.size()) {
            finalList.add(rt1.get(i));
            i++;
        }

        int start = 0;
        int end = finalList.size() - 1;
        return balancedTree(finalList, start, end);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);

        Node root1 = new Node(9);
        root1.left = new Node(3);
        root1.right = new Node(12);

        Node Merge = merge(root, root1);

        preOrder(Merge);
    }
}

/*
 * first take the inorder of the both tree
 * which we will get the two sorted list now we just have to marge those two
 * list
 * by creating the new list
 * then create the tree using the PreOrder
 * 
 */