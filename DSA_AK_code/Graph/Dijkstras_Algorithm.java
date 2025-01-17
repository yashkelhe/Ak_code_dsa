package Graph;

import java.util.*;

public class Dijkstras_Algorithm {
    public static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        // whenerve we implement the Comparable we have to Override the compareTo
        // function to define what bases the our sorting would be

        @Override
        // the new Object come to compare with the existed one
        public int compareTo(Pair p2) {
            // allready path and new Object path and sort on the path bases
            return this.path - p2.path; // Ascending order based on path
        }

    }

    public static void Dijkstras(ArrayList<Edge> graph[], int src) {
        // store all the src to i value
        // dist[i] = src to i
        // i destination
        // it will store the value of u and v means priviose values and current value
        /*
         * Vertex 0: [Edge(0 → 1, 2), Edge(0 → 2, 4)]
         * Vertex 1: [Edge(1 → 2, 1), Edge(1 → 3, 7)]
         * Vertex 2: [Edge(2 → 4, 3)]
         * Vertex 3: [Edge(3 → 5, 1)]
         * Vertex 4: [Edge(4 → 3, 2), Edge(4 → 5, 5)]
         * Vertex 5: []
         */

        int dist[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            // if(i==src) dont need to do anything
            // means if src to src is destance is zero \
            // and make other infinity
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// +infinity
            }
        }
        boolean visi[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // in first adding the src to src path
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            // curr is object and we want a current n = node
            if (!visi[curr.n]) {
                visi[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    // update the distance of src to v
                    if ((dist[u] + wt) < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all src to vertices shortest path
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        Dijkstras(graph, src);

    }

}

/*
 * Iteration 1: Process Node
 * 0
 * 0
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 0
 * ,
 * 0
 * )
 * curr=Pair(0,0)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 0
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[0]=true
 * Process edges from Node
 * 0
 * 0:
 * Edge
 * 0
 * →
 * 1
 * 0→1, weight
 * 2
 * 2:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 1
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * ∞
 * ,
 * 0
 * +
 * 2
 * )
 * =
 * 2
 * dist[1]=min(∞,0+2)=2
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 1
 * ,
 * 2
 * )
 * Pair(1,2) to
 * 𝑝
 * 𝑞
 * pq.
 * Edge
 * 0
 * →
 * 2
 * 0→2, weight
 * 4
 * 4:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 2
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * ∞
 * ,
 * 0
 * +
 * 4
 * )
 * =
 * 4
 * dist[2]=min(∞,0+4)=4
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 4
 * )
 * Pair(2,4) to
 * 𝑝
 * 𝑞
 * pq.
 * Updated dist[] = [0, 2, 4, ∞, ∞, ∞]
 * Priority queue
 * 𝑝
 * 𝑞
 * =
 * [
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 1
 * ,
 * 2
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 4
 * )
 * ]
 * pq=[Pair(1,2),Pair(2,4)].
 * Iteration 2: Process Node
 * 1
 * 1
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 1
 * ,
 * 2
 * )
 * curr=Pair(1,2)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 1
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[1]=true
 * Process edges from Node
 * 1
 * 1:
 * Edge
 * 1
 * →
 * 2
 * 1→2, weight
 * 1
 * 1:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 2
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * 4
 * ,
 * 2
 * +
 * 1
 * )
 * =
 * 3
 * dist[2]=min(4,2+1)=3
 * Update
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 3
 * )
 * Pair(2,3) in
 * 𝑝
 * 𝑞
 * pq.
 * Edge
 * 1
 * →
 * 3
 * 1→3, weight
 * 7
 * 7:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 3
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * ∞
 * ,
 * 2
 * +
 * 7
 * )
 * =
 * 9
 * dist[3]=min(∞,2+7)=9
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 9
 * )
 * Pair(3,9) to
 * 𝑝
 * 𝑞
 * pq.
 * Updated dist[] = [0, 2, 3, 9, ∞, ∞]
 * Priority queue
 * 𝑝
 * 𝑞
 * =
 * [
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 3
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 4
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 9
 * )
 * ]
 * pq=[Pair(2,3),Pair(2,4),Pair(3,9)].
 * Iteration 3: Process Node
 * 2
 * 2
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 3
 * )
 * curr=Pair(2,3)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 2
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[2]=true
 * Process edges from Node
 * 2
 * 2:
 * Edge
 * 2
 * →
 * 4
 * 2→4, weight
 * 3
 * 3:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 4
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * ∞
 * ,
 * 3
 * +
 * 3
 * )
 * =
 * 6
 * dist[4]=min(∞,3+3)=6
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 4
 * ,
 * 6
 * )
 * Pair(4,6) to
 * 𝑝
 * 𝑞
 * pq.
 * Updated dist[] = [0, 2, 3, 9, 6, ∞]
 * Priority queue
 * 𝑝
 * 𝑞
 * =
 * [
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 4
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 9
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 4
 * ,
 * 6
 * )
 * ]
 * pq=[Pair(2,4),Pair(3,9),Pair(4,6)].
 * Iteration 4: Process Node
 * 2
 * 2 (Duplicate Entry)
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 2
 * ,
 * 4
 * )
 * curr=Pair(2,4)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 2
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[2]=true (already visited, skip further processing).
 * Iteration 5: Process Node
 * 4
 * 4
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 4
 * ,
 * 6
 * )
 * curr=Pair(4,6)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 4
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[4]=true
 * Process edges from Node
 * 4
 * 4:
 * Edge
 * 4
 * →
 * 3
 * 4→3, weight
 * 2
 * 2:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 3
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * 9
 * ,
 * 6
 * +
 * 2
 * )
 * =
 * 8
 * dist[3]=min(9,6+2)=8
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 8
 * )
 * Pair(3,8) to
 * 𝑝
 * 𝑞
 * pq.
 * Edge
 * 4
 * →
 * 5
 * 4→5, weight
 * 5
 * 5:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 5
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * ∞
 * ,
 * 6
 * +
 * 5
 * )
 * =
 * 11
 * dist[5]=min(∞,6+5)=11
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 11
 * )
 * Pair(5,11) to
 * 𝑝
 * 𝑞
 * pq.
 * Updated dist[] = [0, 2, 3, 8, 6, 11]
 * Priority queue
 * 𝑝
 * 𝑞
 * =
 * [
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 9
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 8
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 11
 * )
 * ]
 * pq=[Pair(3,9),Pair(3,8),Pair(5,11)].
 * Iteration 6: Process Node
 * 3
 * 3
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 8
 * )
 * curr=Pair(3,8)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 3
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[3]=true
 * Process edges from Node
 * 3
 * 3:
 * Edge
 * 3
 * →
 * 5
 * 3→5, weight
 * 1
 * 1:
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 5
 * ]
 * =
 * 𝑚
 * 𝑖
 * 𝑛
 * (
 * 11
 * ,
 * 8
 * +
 * 1
 * )
 * =
 * 9
 * dist[5]=min(11,8+1)=9
 * Add
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 9
 * )
 * Pair(5,9) to
 * 𝑝
 * 𝑞
 * pq.
 * Updated dist[] = [0, 2, 3, 8, 6, 9]
 * Priority queue
 * 𝑝
 * 𝑞
 * =
 * [
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 9
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 11
 * )
 * ,
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 9
 * )
 * ]
 * pq=[Pair(3,9),Pair(5,11),Pair(5,9)].
 * Iteration 7: Process Node
 * 3
 * 3 (Duplicate Entry)
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 3
 * ,
 * 9
 * )
 * curr=Pair(3,9)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 3
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[3]=true (already visited, skip further processing).
 * Iteration 8: Process Node
 * 5
 * 5
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 9
 * )
 * curr=Pair(5,9)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 5
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[5]=true
 * Node
 * 5
 * 5 has no outgoing edges.
 * Priority queue
 * 𝑝
 * 𝑞
 * =
 * [
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 11
 * )
 * ]
 * pq=[Pair(5,11)].
 * Iteration 9: Process Node
 * 5
 * 5 (Duplicate Entry)
 * 𝑐
 * 𝑢
 * 𝑟
 * 𝑟
 * =
 * 𝑃
 * 𝑎
 * 𝑖
 * 𝑟
 * (
 * 5
 * ,
 * 11
 * )
 * curr=Pair(5,11)
 * 𝑣
 * 𝑖
 * 𝑠
 * 𝑖
 * [
 * 5
 * ]
 * =
 * 𝑡
 * 𝑟
 * 𝑢
 * 𝑒
 * visi[5]=true (already visited, skip further processing).
 * Final Result
 * After all iterations, the shortest distances from the source (
 * 𝑠
 * 𝑟
 * 𝑐
 * =
 * 0
 * src=0) to all nodes are:
 * 
 * dist
 * =
 * [
 * 0
 * ,
 * 2
 * ,
 * 3
 * ,
 * 8
 * ,
 * 6
 * ,
 * 9
 * ]
 * dist=[0,2,3,8,6,9]
 * Explanation of Distances
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 0
 * ]
 * =
 * 0
 * dist[0]=0 → Source node.
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 1
 * ]
 * =
 * 2
 * dist[1]=2 → Path:
 * 0
 * →
 * 1
 * 0→1.
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 2
 * ]
 * =
 * 3
 * dist[2]=3 → Path:
 * 0
 * →
 * 1
 * →
 * 2
 * 0→1→2.
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 3
 * ]
 * =
 * 8
 * dist[3]=8 → Path:
 * 0
 * →
 * 1
 * →
 * 2
 * →
 * 4
 * →
 * 3
 * 0→1→2→4→3.
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 4
 * ]
 * =
 * 6
 * dist[4]=6 → Path:
 * 0
 * →
 * 1
 * →
 * 2
 * →
 * 4
 * 0→1→2→4.
 * 𝑑
 * 𝑖
 * 𝑠
 * 𝑡
 * [
 * 5
 * ]
 * =
 * 9
 * dist[5]=9 → Path:
 * 0
 * →
 * 1
 * →
 * 2
 * →
 * 4
 * →
 * 3
 * →
 * 5
 * 0→1→2→4→3→5.
 */