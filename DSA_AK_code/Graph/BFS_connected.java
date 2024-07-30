package Graph;

import java.util.*;

import Binary_search_tree.validate_BST;


public class BFS_connected {
 public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // vertex 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // vertex 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // vertex 5
        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 2));
        graph[5].add(new Edge(5, 6, 2));
    }

    public static void bfsUtil(ArrayList<Edge>[] graph , boolean [] visit) {
        // create a queue to check the neighbors
        Queue<Integer> qe = new LinkedList<>();

        

        qe.add(0);

        while (!qe.isEmpty()) {
            int curr = qe.remove();
            // if the node is not visited
            if (!visit[curr]) {
                System.out.print(curr + " ");
                // mark the node as visited
                visit[curr] = true;
                // then add the neighbor nodes of the current node, which shows the breadth-first search
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    qe.add(e.dest);
                }
            }
        }
    }   

    // this is for the different graph 
    public static void bfs( ArrayList<Edge>[] graph ){

        boolean visit[] = new boolean[graph.length];

        for(int i =0; i < graph.length; i++){
            if(!visit[i] ){
                // then it will call to the each graph and make it true
                bfsUtil(graph, visit);
            }
        }

    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("The BFS is: ");
        bfs(graph); //O(V+E) 
    }
    
}
