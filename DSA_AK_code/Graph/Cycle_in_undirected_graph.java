package Graph;

import java.util.*;

public class Cycle_in_undirected_graph {
    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        // here we will difine the arraylist forthe all index
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        // for the parent
        boolean vis[] = new boolean[graph.length];
        // for the next neigbour
        // like the currect path
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // its DFS which is used for the undirected graph
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // if the neighbor are visted then return true
            if (stack[e.dest]) {
                return true;
            }
            // if the false then call the nrighboure if they are not visited
            // and after calling if we found that the neighbor in the stack are visted then
            // retrun true
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        // if not found the cycle in the currect path make it false which will help to
        // other path
        // if u set this as true then it will create problem for the next path
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        // adjacency list

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        System.out.println("the graph has been created successfully...");
        createGraph(graph);
        System.out.println("check the cycle");
        System.out.println("is there have any cycle : " + isCycle(graph));
    }

}
