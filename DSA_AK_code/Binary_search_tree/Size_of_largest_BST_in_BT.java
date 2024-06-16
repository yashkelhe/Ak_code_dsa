package Binary_search_tree;

public class Size_of_largest_BST_in_BT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info {
        boolean isBST;
        int size;
        int max;
        int min;

        public Info(boolean isBST, int size, int max, int min) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    // here we will return the info objects
    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // Check if current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            int size = leftInfo.size + rightInfo.size + 1;
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, Math.max(root.data, rightInfo.max), Math.min(root.data, leftInfo.min));
        } else {
            // Current subtree is not a BST
            return new Info(false, 0, 0, 0);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.right = new Node(70);
        root.right.left = new Node(45);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBST(root);
        System.out.println("the largest BST in BT is size = " + maxBST);
    }
}

// Certainly! Let's break down how the algorithm works and then discuss the
// usage of the Info static class.

// Explanation of the Algorithm:
// Recursive Approach: The algorithm utilizes a recursive approach to traverse
// the binary tree in a bottom-up manner.

// Info Class: The Info class is used to store information about each subtree
// encountered during traversal. This information includes:

// isBST: Indicates whether the subtree is a valid binary search tree.
// size: Represents the size of the subtree.
// max: Represents the maximum value in the subtree.
// min: Represents the minimum value in the subtree.
// Traverse Subtrees: The algorithm recursively traverses each subtree (left and
// right) to obtain the Info object containing information about that subtree.

// Determine BST Properties: For each subtree, the algorithm checks if it
// satisfies the properties of a binary search tree:

// The left subtree must be a BST.
// The right subtree must be a BST.
// The root value must be greater than the maximum value in the left subtree and
// less than the minimum value in the right subtree.
// Update MaxBST: If the subtree satisfies the properties of a BST, the
// algorithm updates the maxBST variable with the size of the subtree.

// Return Info Object: Finally, the algorithm returns the Info object for each
// subtree to the parent recursive call.

// Main Function: In the main function, the algorithm is invoked with the root
// of the binary tree. After traversal, it prints the value of maxBST, which
// represents the size of the largest BST in the binary tree.

// Usage of the Info Static Class:
// The Info static class is used to encapsulate information about each subtree
// encountered during traversal. Here's why it's beneficial:

// Encapsulation: It encapsulates related information (isBST, size, max, min)
// into a single object, making it easier to manage and pass around during
// recursive calls.

// Consistency: By defining a class, you ensure consistency in the structure of
// the information being passed between recursive calls.

// Clarity and Readability: Using a class with meaningful attribute names
// (isBST, size, max, min) enhances the clarity and readability of the code,
// making it easier to understand the purpose of each piece of information.

// Reusability: If you need similar information about subtrees in other parts of
// your program, you can reuse the Info class without rewriting the same logic.
