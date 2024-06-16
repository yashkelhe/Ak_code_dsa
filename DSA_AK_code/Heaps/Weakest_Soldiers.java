package Heaps;

import java.util.*;

public class Weakest_Soldiers {
    static class Row implements Comparable<Row> {
        int index;
        int soldiers;

        public Row(int soldiers, int index) {
            this.index = index;
            this.soldiers = soldiers;

        }

        @Override

        public int compareTo(Row r2) {
            // if the soldiers are same then then compare on the index else compare om the
            // soldiers
            if (this.soldiers == r2.soldiers) {
                return this.index - r2.index;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int k = 2;
        PriorityQueue<Row> p = new PriorityQueue<>();

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            // this will add the object in the priority queue
            p.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("R" + p.remove().index);
        }
    }
}
