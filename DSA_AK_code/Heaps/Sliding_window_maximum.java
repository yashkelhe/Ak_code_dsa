package Heaps;

import java.util.*;

// it will take the log(nlogn)
public class Sliding_window_maximum {
    static class Pair implements Comparable<Pair> {
        int index;
        int value;

        public Pair(int value, int index) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair q2) {
            // ascending order
            // return this.value - q2.value;
            // descending order
            return q2.value - this.value;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;// window size
        int res[] = new int[arr.length - k + 1]; // oupput

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // store the k pairs
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));

        }
        // the 1st window result will be the
        res[0] = pq.peek().value;

        for (int i = k; i < arr.length; i++) {
            // we have to remove the all the privouse window element
            while (pq.size() > 0 && pq.peek().index <= (i - k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().value;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
    }

    // the code is remaining you have tp complete this code

}
