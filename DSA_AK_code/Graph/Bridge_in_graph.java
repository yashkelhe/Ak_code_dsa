package Graph;

import java.util.ArrayList;

public class Bridge_in_graph {
    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.dest = dest;
            this.src = src;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int dt[], int low[], boolean visi[], int time) {
        visi[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            int neigh = e.dest;
            if (neigh == par) {
                // next iteration
                continue;
            } else if (!visi[neigh]) {
                dfs(graph, e.dest, curr, dt, low, visi, time);
                // update the low
                low[curr] = Math.min(low[curr], low[e.dest]);
                // when its start to backtrack we will check thazt the condition is satisfied
                // for the bridge
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge found : " + curr + " -> " + neigh);
                }
            } else {
                // if already visted then find the min between the dest and curr
                low[curr] = Math.min(low[curr], dt[e.dest]);

            }
        }
    }

    public static void tarjansBridge(ArrayList<Edge>[] graph, int v) {
        int dt[] = new int[v];
        int low[] = new int[v];
        boolean visi[] = new boolean[v];
        int time = 0;
        for (int i = 0; i < v; i++) {
            if (!visi[i]) {
                dfs(graph, i, -1, dt, low, visi, time);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        tarjansBridge(graph, v);
    }
}

/*
 * Start DFS at Node 0:
 * Visit Node 0:
 * 
 * Mark visi[0] = true
 * Update dt[0] = 1, low[0] = 1
 * Updated values:
 * dt = [1, -1, -1, -1, -1, -1]
 * low = [1, -1, -1, -1, -1, -1]
 * Move to Neighbor Node 1:
 * 
 * Mark visi[1] = true
 * Update dt[1] = 2, low[1] = 2
 * Updated values:
 * dt = [1, 2, -1, -1, -1, -1]
 * low = [1, 2, -1, -1, -1, -1]
 * Node 1 -> Neighbor Node 0:
 * 
 * par is 0, so skip.
 * Node 1 -> Neighbor Node 2:
 * 
 * Mark visi[2] = true
 * Update dt[2] = 3, low[2] = 3
 * Updated values:
 * dt = [1, 2, 3, -1, -1, -1]
 * low = [1, 2, 3, -1, -1, -1]
 * Node 2 -> Neighbor Node 0:
 * 
 * Node 0 is already visited. Update low[2] = min(low[2], dt[0]) = min(3, 1) =
 * 1.
 * Updated values:
 * low = [1, 2, 1, -1, -1, -1]
 * Node 2 -> Neighbor Node 1:
 * 
 * Node 1 is already visited. Update low[2] = min(low[2], dt[1]) = min(1, 2) =
 * 1.
 * Updated values:
 * low = [1, 2, 1, -1, -1, -1]
 * Backtrack to Node 1:
 * 
 * Update low[1] = min(low[1], low[2]) = min(2, 1) = 1.
 * No bridge found since dt[1] < low[2] is false.
 * Updated values:
 * low = [1, 1, 1, -1, -1, -1]
 * Backtrack to Node 0:
 * 
 * Update low[0] = min(low[0], low[1]) = min(1, 1) = 1.
 * No bridge found since dt[0] < low[1] is false.
 * Updated values:
 * low = [1, 1, 1, -1, -1, -1]
 * Node 0 -> Neighbor Node 2:
 * 
 * Already visited. Update low[0] = min(low[0], dt[2]) = min(1, 3) = 1.
 * Updated values:
 * low = [1, 1, 1, -1, -1, -1]
 * Node 0 -> Neighbor Node 3:
 * 
 * Mark visi[3] = true
 * Update dt[3] = 4, low[3] = 4
 * Updated values:
 * dt = [1, 2, 3, 4, -1, -1]
 * low = [1, 1, 1, 4, -1, -1]
 * Node 3 -> Neighbor Node 0:
 * 
 * Already visited. Update low[3] = min(low[3], dt[0]) = min(4, 1) = 1.
 * Updated values:
 * low = [1, 1, 1, 1, -1, -1]
 * Continue DFS at Node 3:
 * Node 3 -> Neighbor Node 4:
 * 
 * Mark visi[4] = true
 * Update dt[4] = 5, low[4] = 5
 * Updated values:
 * dt = [1, 2, 3, 4, 5, -1]
 * low = [1, 1, 1, 1, 5, -1]
 * Node 4 -> Neighbor Node 3:
 * 
 * Already visited. Update low[4] = min(low[4], dt[3]) = min(5, 4) = 4.
 * Updated values:
 * low = [1, 1, 1, 1, 4, -1]
 * Node 4 -> Neighbor Node 5:
 * 
 * Mark visi[5] = true
 * Update dt[5] = 6, low[5] = 6
 * Updated values:
 * dt = [1, 2, 3, 4, 5, 6]
 * low = [1, 1, 1, 1, 4, 6]
 * Node 5 -> Neighbor Node 3:
 * 
 * Already visited. Update low[5] = min(low[5], dt[3]) = min(6, 4) = 4.
 * Updated values:
 * low = [1, 1, 1, 1, 4, 4]
 * Node 5 -> Neighbor Node 4:
 * 
 * Already visited. Update low[5] = min(low[5], dt[4]) = min(4, 5) = 4.
 * Updated values:
 * low = [1, 1, 1, 1, 4, 4]
 * Backtrack to Node 4:
 * 
 * Update low[4] = min(low[4], low[5]) = min(4, 4) = 4.
 * No bridge found since dt[4] < low[5] is false.
 * Updated values:
 * low = [1, 1, 1, 1, 4, 4]
 * Backtrack to Node 3:
 * 
 * Update low[3] = min(low[3], low[4]) = min(1, 4) = 1.
 * Bridge found: 3 -> 4
 * Updated values:
 * low = [1, 1, 1, 1, 4, 4]
 * Final Bridges Found:
 * 3 -> 4
 */