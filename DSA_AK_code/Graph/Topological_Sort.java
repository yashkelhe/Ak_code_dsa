package Graph;

import java.util.*;

public class Topological_Sort {
    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] visi = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        // the loop for the all the graph which exists in the single graph
        for (int i = 0; i < graph.length; i++) {
            if (!visi[i]) {
                topSortUtil(graph, i, visi, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ",");

        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean visi[], Stack<Integer> stack) {
        visi[curr] = true;
        System.out.println("after calling " + curr);
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // if the neighours are not true then add make it true
            if (!visi[e.dest]) {
                topSortUtil(graph, e.dest, visi, stack);
            }
        }
        // i just want to know that whne its iterating at that time if he found that all
        // the neigboure are visited it directly come out to the for loop
        // yes it directly come out
        // If all the neighbors have been visited, the for loop completes its iteration.
        System.out.println("the curr is here : " + curr);
        stack.push(curr);
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topSort(graph);
    }

}
