package Greedy_Algorithm;

import java.util.*;

// when the end time is not  sort 
public class Activity_selection_sorting {
    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        int activities[][] = new int[start.length][3];

        // why we are taking the 2d array becouse the we have store the orginal inndex
        // also
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // for sort the end we will use the lambda function which is comparator is an
        // interface for sorting
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        // we have givin the column index which needs to sorted
        int maxAct = 0;
        // for to count the number of activities are happend

        // for to add the index of the activity to know which activity is done
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastend = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastend) {
                maxAct++;
                ans.add(activities[i][0]);
                lastend = activities[i][2];
            }

        }
        System.out.println("max Activities are : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }

    }
}
