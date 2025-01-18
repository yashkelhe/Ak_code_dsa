package Graph;

import java.util.ArrayList;

public class Articulation_Point {
    public static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {
            this.dest = dest;
            this.src = src;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // time complexty O(V+E)
    // If dt[3] = 4, it means node 3 was the 4th node visited during the DFS
    // traversal.
    // Definition: The low-link value of a node is the smallest discovery time
    // reachable from that node, either directly or through its descendants
    // (excluding the parent in the DFS tree).

    // descendants (excluding the parent in the DFS tree).
    // If low[4] = 1, it means node 4 can reach back to the node discovered at time
    // 1
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean visi[],
            boolean ap[]) {

        visi[curr] = true;
        // preincrement
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            // check the condition
            // if its equal to parent then skip it
            // if its visited then compare the dt dest and low of source means get the
            // sortes way to react that point
            // if not visited then call to neighbour and once it reaches to base case then
            // return and at the backtrack calulate the
            // low and also check weather the its ap or not

            if (par == neigh) {
                continue;
            } else if (visi[neigh]) {
                // update the low
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, time, visi, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                // if is it equal to the -1 then its only one node is there which indicating the
                // there self
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if (par == -1 && children > 1) {
            ap[curr] = true;

        }
    }

    // If node 4 can reach back to a node before 3 through other edges (like 4 -> 5
    // -> 3), low[4] will be updated to reflect the earliest reachable node.
    // If there’s no way to reach back, the edge connecting 3 -> 4 is a bridge.

    public static void getAp(ArrayList<Edge> graph[], int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean visi[] = new boolean[v];
        int time = 0;
        boolean ap[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visi[i]) {
                dfs(graph, i, -1, dt, low, time, visi, ap);
            }
        }
        for (int i = 0; i < v; i++) {
            if (ap[i]) {

                System.out.println("Ap is : " + i);
            }

        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        getAp(graph, v);
    }

}
