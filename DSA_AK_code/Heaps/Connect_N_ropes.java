package Heaps;

import java.util.*;

public class Connect_N_ropes {

    public static void main(String[] args) {

        int ropes[] = { 2, 3, 3, 4, 6 };

        int cost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            q.add(ropes[i]);
        }

        while (1 < q.size()) {
            int min1 = q.remove();
            int min2 = q.remove();

            cost += min1 + min2;
            q.add(min1 + min2);

        }

        System.out.println("the cost of the n connecting ropes  = " + cost);
    }
}
