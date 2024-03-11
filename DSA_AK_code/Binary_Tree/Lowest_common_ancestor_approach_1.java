package Binary_Tree;

import java.util.*;

// the time complexity is O(n)
// how
// first getPath take O(n)
// first getPath take O(n)
// then loop also run up to O(n)
// so  O(n+n+n) = O(n)
// also space complexity is O(n) becouse we are using the arrayList 

public class Lowest_common_ancestor_approach_1 {
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

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {

            return false;
        }
        path.add(root);

        // it says we got value here dont go more deeper
        if (root.data == n) {
            return true;
        }

        // check the path where Node exits
        boolean leftPath = getPath(root.left, n, path);
        boolean rightPath = getPath(root.right, n, path);

        // if any path is ture means our node is exits in the tree
        if (leftPath || rightPath) {
            return true;
        }

        // if not then all the left and right already remove but the root node is still
        // there that also we will remove
        path.remove(path.size() - 1);

        return false;

    }

    public static Node LowestCommanAncesetor(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // get path will store the path in the arrayList
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            // check for the not equal to the loop will run up to equal number as the
            // unequal number comes loop will be out
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // i -1 will be on the last common ancestor
        Node lca = path1.get(i - 1);
        return lca;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4, n2 = 6;
        System.out.println(LowestCommanAncesetor(root, n1, n2).data);
    }
}
