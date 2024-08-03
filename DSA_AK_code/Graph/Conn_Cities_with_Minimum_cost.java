package Graph;

import java.util.*;

public class Conn_Cities_with_Minimum_cost {
    public static class Edge implements Comparable<Edge> {

        int dest;
        int cost;

        public Edge(int dest, int cost) {

            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {

            return this.cost - e2.cost;
        }
    }

    public static int connectedCities(int cities[][]) {
        // it will auotmatically sort based on the cost
        PriorityQueue<Edge> q = new PriorityQueue<>();
        boolean visi[] = new boolean[cities.length];

        q.add(new Edge(0, 0));
        int finalCost = 0;

        while (!q.isEmpty()) {
            Edge curr = q.remove();

            if (!visi[curr.dest]) {
                visi[curr.dest] = true;
                finalCost += curr.cost;
                for (int i = 0; i < cities[curr.dest].length; i++) {

                    // if== 0 then there is no Edge
                    if (cities[curr.dest][i] != 0) {

                        q.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        int result = connectedCities(cities);
        System.out.println(result);
    }
}
