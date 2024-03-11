package Greedy_Algorithm;

// importent question 
// find how much weight and value  can fit in the knapsack 
import java.util.*;
// O(nlogn)

public class Fractional_knapsack {
    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        // the maximum weight can fit in the knapsack
        int maxWeight = 50;

        double ratio[][] = new double[value.length][2];
        // 0th => col is for index , 1st => ratio

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        // but we want in the discending order

        int capacity = maxWeight;
        int finalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int index = (int) ratio[i][0];
            if (capacity >= weight[index]) {
                finalValue += value[index];
                capacity -= weight[index];
            } else {
                // include the fractional items
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("maximum final ouput is the : " + finalValue);
    }
}
