package Graph;

import java.util.*;

public class Cheapest_Flight_k_Stops_Path {

    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(int flight[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops) {
            this.cost = cost;
            this.vertex = vertex;
            this.stops = stops;
        }
    }

    public static int CheapestFlight(int n, int flight[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flight, graph);

        int dist[] = new int[n];
        // fill the hole array with the +infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        // then make the first 0 as 0
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            // k = 3
            if (curr.stops > k) {
                continue;
            }
            // loop all the curr neighbours
            for (Edge e : graph[curr.vertex]) {

                int v = e.dest;
                int wt = e.wt;
                // relaxation formula
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    // next vertex
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int flight[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;

        int i = CheapestFlight(n, flight, src, dest, k);
        System.out.println(i); // Output should be 700
    }
}
