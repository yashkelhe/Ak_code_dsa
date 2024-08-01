package Graph;

import java.util.*;

public class Bellman_Algorithm {
    public static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void createGraph2(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    // O(V*E) time complexty of this Algo
    public static void BellmanAlgo(ArrayList<Edge> graph[], int src) {
        // to store the src to i value
        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // O(V*E)
        // V-1 O(v)
        for (int i = 0; i < graph.length - 1; i++) {
            // to find the all the edges and the time complexty will be same even as we are
            // using the two loops
            // O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    // relaxation
                    // IMP Note when we add the integer in the infinity in the java it becomes a
                    // negative so to avoid that
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void BellmanAlgo2(ArrayList<Edge> graph, int src, int v) {
        // to store the src to i value
        int dist[] = new int[v];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        // O(V*E)
        // V-1 O(v)
        for (int i = 0; i < v - 1; i++) {
            // to find the all the edges and the time complexty will be same even as we are
            // using the two loops
            // O(E)
            for (int j = 0; j < graph.size(); j++) {

                Edge e = graph.get(j);
                int u = e.src;
                int ve = e.dest;
                int wt = e.weight;
                // relaxation
                // IMP Note when we add the integer in the infinity in the java it becomes a
                // negative so to avoid that
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[ve]) {
                    dist[ve] = dist[u] + wt;
                }

            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        BellmanAlgo(graph, src);
        // simple way but the time complexty will be same
        System.out.println("Method 2 which take same time complexty  O(VE)");
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph2(edges);
        BellmanAlgo2(edges, 0, v);

    }

}
