package Graph;

import java.util.*;

public class create_graph_adjacency {
    public static  class Edge {
        int dist;
        int src ;
        int weight;

        public Edge (int s , int d , int w){
                this.dist   = d ;
                this.weight   = w ;
                this.src   = s ;
        }

    }

    public static void main(String[] args) {
            int v= 5;
            // this is basically array of arrayList
            // here we are creating a lewnght of 5 array 

            // int arry [] = new int [v]
            // so heere we just have chenge the  type 
            ArrayList<Edge> [] graph  = new ArrayList [v];

            // now here we have created a arrayList but its emty there is no arrylist 
            for(int i =  0; i<v; i++){
                    graph[i] = new ArrayList<>();
            }
            // vertix  0
            graph[0].add(new Edge(0, 1, 5));
            
            // vertix  1
            graph[1].add(new Edge(1, 2, 1));
            graph[1].add(new Edge(1, 3, 3));
            // vertix  2
            graph[2].add(new Edge(2, 1, 1));
            graph[2].add(new Edge(2, 4, 2));
            graph[2].add(new Edge(2, 3, 1));
            // vertix  3
            graph[3].add(new Edge(3, 1, 3));
            graph[3].add(new Edge(3, 2, 1));
            // vertix  4
            graph[4].add(new Edge(4, 2, 2));
            

            for(int   i = 0 ; i< graph[2].size(); i++){
                // to go on the graphp[2] and get the arrayList of with src dist and weight
                Edge e = graph[2].get(i); 
                System.out.println("destination "+ e.dist+ " source "+ e.src + " weight " + e.weight);
            }
    }

}
