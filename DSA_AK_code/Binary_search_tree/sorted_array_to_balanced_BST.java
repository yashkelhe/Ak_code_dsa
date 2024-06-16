package Binary_search_tree;

public class sorted_array_to_balanced_BST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    // inorder
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        // l.rt.r
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node createBalancedTreeFormSortedArray(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = createBalancedTreeFormSortedArray(arr, start, mid - 1);
        root.right = createBalancedTreeFormSortedArray(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {

        int arr[] = { 3, 6, 5, 8, 10, 11, 12 };
        Node root = createBalancedTreeFormSortedArray(arr, 0, arr.length - 1);
        inorder(root);
    }
}
