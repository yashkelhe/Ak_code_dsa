package Graph;

import java.util.*;

public class KosaRajus_Algo {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean[] visi, Stack<Integer> stack) {
        visi[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visi[e.dest]) {
                topSort(graph, e.dest, visi, stack);
            }
        }
        stack.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visi[]) {
        visi[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visi[e.dest]) {
                dfs(graph, e.dest, visi);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int v) {
        // step 1
        Stack<Integer> stack = new Stack<>();
        boolean[] visi = new boolean[graph.length];

        for (int i = 0; i < v; i++) {
            if (!visi[i]) {
                topSort(graph, i, visi, stack);
            }
        }

        // step 2
        // make the transpose
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for (int i = 0; i < transpose.length; i++) {
            // why becouse above we have used the visi and now again next we want to use so
            // first lets make it false to everyone and then we can use next
            visi[i] = false;
            transpose[i] = new ArrayList<>();
        }

        // now make the copy
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);

                int src = e.src;
                int dest = e.dest;
                // reverse the graph
                transpose[dest].add(new Edge(dest, src));
            }
        }
        // step 3
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visi[curr]) {
                dfs(transpose, curr, visi);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("the graph is created");
        kosaraju(graph, v);
    }

}