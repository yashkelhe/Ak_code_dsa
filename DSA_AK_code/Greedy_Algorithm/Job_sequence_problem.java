package Greedy_Algorithm;

import java.util.*;

// TC is O(n log n)
public class Job_sequence_problem {

    // this is basically a blue print of object
    static class job {
        int deadLine;
        int profit;
        int id;

        public job(int id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        // store in the arraylist
        ArrayList<job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // syntex of the sorting object in decending order
        // lambda function
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            job curr = jobs.get(i);
            if (curr.deadLine > time) {
                seq.add(curr.id);
                time++;
            }
        }
        // print seq;
        System.out.println("maximum jobs are " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
    }
}
