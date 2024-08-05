package Binary_Tree;

import java.util.*;

public class Top_view_of_Binary_tree {
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
        Node node;
        int horiDis;

        public info(Node node, int horiDis) {
            this.node = node;
            this.horiDis = horiDis;
        }
    }

    public static void topView(Node root) {
        // level order
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(new info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // when the key is not in the map then add the value in the map
                if (!map.containsKey(curr.horiDis)) {
                    map.put(curr.horiDis, curr.node);
                }
                // here info object in the curr

                if (curr.node.left != null) {
                    // for the left side of the HD
                    q.add(new info(curr.node.left, curr.horiDis - 1));
                    min = Math.min(min, curr.horiDis - 1);
                }
                if (curr.node.right != null) {
                    // for the left side of the HD
                    q.add(new info(curr.node.right, curr.horiDis + 1));
                    max = Math.max(max, curr.horiDis + 1);
                }
            }

        }
        System.out.println("min : " + min + " max : " + max);
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        // root.left.left.left = new Node(2);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        topView(root);

    }
}
