package Graph;

import java.util.*;

public class BFS {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // vertex 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // vertex 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // vertex 5
        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 2));
        graph[5].add(new Edge(5, 6, 2));
    }

    public static void bfs_check(ArrayList<Edge>[] graph) {
        // create a queue to check the neighbors
        Queue<Integer> qe = new LinkedList<>();

        boolean visit[] = new boolean[graph.length];

        qe.add(0);

        while (!qe.isEmpty()) {
            int curr = qe.remove();
            // if the node is not visited
            if (!visit[curr]) {
                System.out.print(curr + " ");
                // mark the node as visited
                visit[curr] = true;
                // then add the neighbor nodes of the current node, which shows the breadth-first search
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    qe.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("The BFS is: ");
        bfs_check(graph); //O(V+E)
    }
}
