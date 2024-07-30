package Graph;

import java.util.*;

public class Bipartial_graph {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(0, 0));
        graph[1].add(new Edge(0, 3));

        graph[2].add(new Edge(0, 0));
        graph[2].add(new Edge(0, 4));

        graph[3].add(new Edge(0, 2));
        // graph[3].add(new Edge(0, 4));

        graph[4].add(new Edge(0, 2));
        // graph[4].add(new Edge(0, 3));

    }

    // here we are using rthe BFS
    // and time complexty will be O(V+E)
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        // to insert the -1 in the array
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> qe = new LinkedList<>();

        // now this outer loop will go to the all the graphs which are available in the
        // same graph there can be chance that one graph can have the multiple graph
        for (int i = 0; i < graph.length; i++) {
            // now here will check first that is col is -1 for to check wather the node has
            // colored or not
            if (col[i] == -1) {
                qe.add(i);
                col[i] = 0;// yellow
                while (!qe.isEmpty()) {
                    // first remove the element form the queue and then check for that

                    int curr = qe.remove();
                    // now check the neighbour of the curr element
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); // e.dest

                        // now there will three case
                        // first there is no color to the neighbours
                        // second the colors are deffierent
                        // third the color are same now then return then false that for this is not an
                        // isBipartite
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            qe.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;// not bipartite
                        }

                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // here we are using the BFS
        int v = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("the graph is BiPartite : " + isBipartite(graph));
    }
}
