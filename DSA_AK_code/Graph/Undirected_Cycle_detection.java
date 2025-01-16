package Graph;

import java.util.ArrayList;

public class Undirected_Cycle_detection {
    public static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

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

        // vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        // vertex 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // vertex 4
        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycleUtill(ArrayList<Edge>[] graph, boolean[] visit, int curr, int parent) {
        visit[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!visit[e.dest]) {
                if (detectCycleUtill(graph, visit, e.dest, curr)) {

                    return true;
                }
            }
            // case 1
            else if (visit[e.dest] && e.dest != parent) {
                return true;
            }
            // case 2 continue
            // if the dest is equal to the parent then skip
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {

        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                // then it will call to the each graph and make it true
                if (detectCycleUtill(graph, visit, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        System.out.println("graph is crearted");
        createGraph(graph);
        System.out.println("the graph has cycle  : " + detectCycle(graph));

    }
}
/*
 * Case 3:
 * If the neighbor (e.dest) has not been visited, recursively call
 * detectCycleUtill for that neighbor.
 * 
 * Case 1:
 * If the neighbor (e.dest) is already visited but is not the parent, it means
 * there is a back edge, indicating a cycle.
 * 
 * Case 2:
 * If the neighbor is the parent, it is part of the undirected graph's traversal
 * and should be ignored.
 * 
 */