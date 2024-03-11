package Binary_Tree;

public class PreOrder_InOrder_PostOrder_traversal {

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

    static class Binary_tree {
        static int index = -1;

        public static Node addChar(char[] data) {
            index++;
            if (data[index] == 'n') {
                return null;
            }
            Node newNode = new Node(data[index]);
            newNode.left = addChar(data);
            newNode.right = addChar(data);

            return newNode;
        }

        // takes O(n) time complexity
        public static void preOrder(Node root) {
            if (root == null) {
                // if just add this you will get hole orginal aarrays
                // System.out.print('n' + " ");

                return;
            }
            // here the value is printing but we want a char so we just type cast the output
            System.out.print((char) root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // takes O(n) time complexity
        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            // in inOrder first l rt r
            inOrder(root.left);
            System.out.print((char) root.data + " ");
            inOrder(root.right);
        }

        // takes O(n) time complexity
        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print((char) root.data + " ");
        }
    }

    public static void main(String[] args) {
        char nams[] = { 'y', 'r', 'm', 'n', 'n', 'n', 'n' };
        Binary_tree bt = new Binary_tree();
        Node root = bt.addChar(nams);
        System.out.println("preOrder ");
        bt.preOrder(root);
        System.out.println("\ninorder");
        bt.inOrder(root);
        System.out.println("\npostorder");
        bt.postOrder(root);
    }
}
