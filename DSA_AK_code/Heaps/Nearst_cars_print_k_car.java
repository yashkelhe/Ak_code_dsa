package Heaps;

import java.util.*;

public class Nearst_cars_print_k_car {

    // Point class is serving as a blueprint for creating objects that store
    // information about points in 2D space. These objects are then stored in a
    // priority queue (PriorityQueue<Point> q) based on their distSq attribute.

    // we use class when we have to store the each element with there sub element
    // means like there are lot of king and each king has there own soldiers so for
    // that we use the class to tell that each king has there own soldiers and which
    // soldiers
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int index;

        public Point(int x, int y, int distSq, int index) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.index = index;
        }

        @Override
        // the second point will be come and comapare with previouse one
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // for which bases of the sorting would be done
        }
    }

    public static void main(String[] args) {

        int arr[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2; // this many cars closest

        // create a priority queue ;
        PriorityQueue<Point> q = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            // i represents the index of the row.
            // [0] represents the index of t he column.
            int distSq = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
            q.add(new Point(arr[i][0], arr[i][1], distSq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + q.remove().index);
        }
    }
}
