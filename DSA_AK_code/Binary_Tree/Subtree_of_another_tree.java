package Binary_Tree;

public class Subtree_of_another_tree {
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

    public static boolean isIdentical(Node root, Node subtree) {
        // when both null
        // this are the conditon for the non identical if any one is treu then return
        // flase or return true
        if (root == null && subtree == null) {
            return true;
        } else if (root == null || subtree == null || root.data != subtree.data) {
            return false;
        }

        // this is recursion if the uper condition becomne true and gives ouput as false
        // the not will convert into true and below alsp become true return false ;
        if (!isIdentical(root.left, subtree.left)) {
            return false;
        }
        if (!isIdentical(root.right, subtree.right)) {
            return false;
        }

        return true;

    }

    public static boolean isSubtree(Node root, Node subtree) {

        if (root == null) {
            return false;
        }
        if (root.data == subtree.data) {
            if (isIdentical(root, subtree)) {
                return true;
            }
        }
        // it means that ur standing in road and there are two path u have choose one
        // for that if the data is match then we will go to that direction
        return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        // root.left.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subtree = new Node(2);
        subtree.left = new Node(4);
        subtree.right = new Node(5);

        System.out.println(isSubtree(root, subtree));
    }
}
