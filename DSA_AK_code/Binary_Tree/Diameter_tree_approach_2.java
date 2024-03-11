package Binary_Tree;

// in this method we are going to return the info object
// this will take O(n) time complexity
public class Diameter_tree_approach_2 {
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

    static class info {
        int diam;
        int height;

        public info(int diam, int height) {

            this.diam = diam;
            this.height = height;
        }
    }

    // this will take the O(n) time complexity becouse we are calculating the both
    // heoght and diam at some time that is here we dont requires extra time to
    // calculate daim and height
    public static info diameter(Node root) {
        // and the basecase will be when we are in the child position that time our diam
        // and ht is 0 ;
        if (root == null) {
            return new info(0, 0);
        }

        // this will give use the all the info which we required like diameter and
        // height for left and right side
        info leftInfo = diameter(root.left);
        info rightInfo = diameter(root.right);

        int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), rightInfo.height + leftInfo.height + 1);

        // there are two ways to calculate the height of the tree first by the nodes and
        // second is by the edges here we have considerd Nodes
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new info(diameter, height);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // this will return the object so we only want the diam so use .diam
        System.out.println(diameter(root).diam);
    }
}
