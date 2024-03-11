package Binary_Tree;

import java.io.OutputStream;

import Binary_Tree.create_binary_tree.BinaryTree;

// and the time complexity of the code is O(n);
public class create_binary_tree {
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

    static class BinaryTree {
        static int index = -1;

        public static Node buildNode(int nodes[]) {
            index++;
            if (-1 == nodes[index]) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildNode(nodes);// left sub tree
            newNode.right = buildNode(nodes);// right sub tree

            return newNode;

        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            // in preOrder first l rt r
            preOrder(root.left);
            System.out.print(root.data + " ");
            preOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildNode(nodes);

        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        // System.out.println(root.data);
    }
}
