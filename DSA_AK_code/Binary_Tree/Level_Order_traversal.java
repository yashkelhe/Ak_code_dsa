package Binary_Tree;

import java.util.*;

public class Level_Order_traversal {
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

    static class Binary_Tree {
        static int index = -1;

        public static Node add(int[] nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = add(nodes);
            newNode.right = add(nodes);
            return newNode;
        }

        // we willl use the BFS with the queue and this also take the O(n)
        public static void LevelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> queue = new LinkedList<>();

            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                Node currentNode = queue.remove();
                if (currentNode == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }

                } else {
                    System.out.print(currentNode.data);
                    // if the right and left child is not null then add that element int he qqueue
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Binary_Tree tree = new Binary_Tree();
        Node root = tree.add(nodes);

        tree.LevelOrder(root);
    }
}
