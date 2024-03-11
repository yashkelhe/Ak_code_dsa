package Binary_Tree;

import java.util.*;

public class Kth_level_of_a_tree {
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

    // approach 1 -> using Level order traversal
    // time complexity is O(n)
    public static void kthOrder(Node root, int k) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        int pointer = 0;
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    pointer++;
                    q.add(null);
                }
            } else {
                if (pointer == k - 1) {
                    System.out.print(curr.data + " ");
                }
                // if left and right is not null then add in queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
        }
    }

    // approach 2 ->
    public static void kthLevel(Node root, int level, int k) {

        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
        }
        // go to each node and cheack for the level if the level become equal to the k
        // then print value
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int k = 3;
        kthOrder(root, k);
        System.out.println();
        kthLevel(root, 1, k); // level is 1 tree level start form 1
    }
}
