package Greedy_Algorithm;

import java.util.*;

// the similar problmes comes in the interview on the Disjoint and maximum metting in the room
public class Activity_selection {
    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        // now we have to sort the start time on the basis of the end time
        int maxAct = 0;
        // for to count the number of activities are happend

        // for to add the index of the activity to know which activity is done
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(0);
        int lastend = end[0];

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastend) {
                maxAct++;
                ans.add(i);
                lastend = end[i];
            }

        }
        System.out.println("max Activities are : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }

    }
}
