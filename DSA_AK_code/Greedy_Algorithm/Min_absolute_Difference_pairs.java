package Greedy_Algorithm;

import java.util.*;

public class Min_absolute_Difference_pairs {
    public static void main(String[] args) {

        int a[] = { 1, 2, 3 };
        int b[] = { 2, 1, 3 };

        Arrays.sort(a);
        Arrays.sort(b);
        // { 1, 2, 3 }
        // { 1, 2, 3 }
        int minDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }
        System.out.println(" minmum absolute difference pairs is " + minDiff);
    }
}
