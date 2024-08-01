package Graph;

import java.util.*;

public class Dijkstras_Algorithm {
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

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        // whenerve we implement the Comparable we have to Override the compareTo
        // function to define what bases the our sorting would be

        @Override
        // the new Object come to compare with the existed one
        public int compareTo(Pair p2) {
            // allready path and new Object path and sort on the path bases
            return this.path - p2.path;
        }

    }

    public static void Dijkstras(ArrayList<Edge> graph[], int src) {
        // store all the src to i value
        // dist[i] = src to i
        // i destination
        // it will store the value of u and v means priviose values and current value
        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            // if(i==src) dont need to do anything
            // means if src to src is destance is zero \
            // and make other infinity
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// +infinity
            }
        }
        boolean visi[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // in first adding the src to src path
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            // curr is object and we want a current n = node
            if (!visi[curr.n]) {
                visi[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    // update the distance of src to v
                    if ((dist[u] + wt) < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all src to vertices shortest path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        Dijkstras(graph, src);

    }

}
