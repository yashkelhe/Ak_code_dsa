package Heaps;

import java.util.*;

public class Create_PriorityQueue_Using_JCF {

    public static void main(String[] args) {
        // this will store the elements in the ascending order
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // and this will store in the discending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(4); // O(logn)
        pq.add(9);
        pq.add(1);
        pq.add(2);
        pq.add(6);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // O(log n)
        }

    }

}
