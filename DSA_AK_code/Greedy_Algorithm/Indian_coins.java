package Greedy_Algorithm;

import java.util.*;

// `TC = O(nlogn)` stands for Time Complexity equals Big O of n log n. It represents the time
// complexity of the algorithm used in the code. In this case, the algorithm has a time complexity of
// O(n log n), which means the time taken by the algorithm to run increases linearly with the input
// size n, but the rate of increase is logar+ithmic.
// TC =O(nlogn)
public class Indian_coins {
    public static void main(String[] args) {
        Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        int amount = 121;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            // if (coins[i] <= amount) {

            while (coins[i] <= amount) {
                count++;
                ans.add(coins[i]);
                amount = amount - coins[i];
            }
            // }
        }
        System.out.print(count + "(");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + ",");
        }
        System.out.print(")");
    }
}
