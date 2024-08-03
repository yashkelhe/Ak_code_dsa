package Graph;

import java.util.*;

public class kruskals {
    public static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(1, 3, 50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // initialize the parent with
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

    }

    public static int find(int x) {
        // we are finding the parent of parnet until we get the superme parent
        if (x == par[x]) {
            return x;
        }
        // optimization path compression
        // as we are again and again calling to the parent becouse of that we will store
        // the parent so we dont need to call the again and again
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            // we can also ddo this becouse rthe rank of the both is same
            // par[parA] = parB;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {

            par[parA] = parB;

        } else {

            par[parB] = parA;
        }

    }

    public static void Kruskals_Algo(ArrayList<Edge> edges, int v) {
        init();
        Collections.sort(edges); // O(ElogE)
        int MstCost = 0;
        int count = 0;

        for (int i = 0; count < v - 1; i++) {
            Edge e = edges.get(i);
            // to check the cycle
            // if the src and dest has same parent meas they are in the same set and cycle
            // can be formed
            int parA = find(e.src);
            int parB = find(e.dest);
            // if both are not part of the some parent then we will called the union to make
            // it same parent
            if (parA != parB) {
                union(parA, parB);
                MstCost += e.weight;
                count++;
            }
        }
        System.out.println("the MST cost is : " + MstCost);
    }

    public static void main(String[] args) {
        // O(V + ElogE )
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        Kruskals_Algo(edges, v);
    }

}
