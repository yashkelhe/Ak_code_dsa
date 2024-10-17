package DP;

import java.util.Arrays;

// 0 1 knapsack 
public class Knapsack_01 {
    // the time complexty is O(2^ n)
    public static int knapsackFindMaxValue(int value[], int weight[], int w, int n) {
        // any time when the base case wants to find then think which variable are
        // changeing
        if (w == 0 || n == 0) {
            return 0;
        }

        // there will be two cases that if the weight is less then the "w "
        // and the weight is more the "w "
        if (weight[n - 1] <= w) {
            // we have to find the max value then first find the value by including
            // wy value[n-1] becouse we want to see the value with inclcuding and excluding
            // the value
            // w - weight[n - 1],to get the remaaining weight to fill buy others

            int ans1 = value[n - 1] + knapsackFindMaxValue(value, weight, w - weight[n - 1], n - 1);
            // and then excluding
            int ans2 = knapsackFindMaxValue(value, weight, w, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsackFindMaxValue(value, weight, w, n - 1);
        }
    }

    // the time complexty is O(n* w)
    public static int usingMemoizationKnapSack(int value[], int weight[], int w, int n, int DP[][]) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (DP[n][w] != -1) {
            return DP[n][w];
        }
        if (weight[n - 1] <= w) {
            // includes
            int ans1 = value[n - 1] + usingMemoizationKnapSack(value, weight, w - weight[n - 1], n - 1, DP);
            // and then excluding
            int ans2 = usingMemoizationKnapSack(value, weight, w, n - 1, DP);
            DP[n][w] = Math.max(ans1, ans2);
            return DP[n][w];
        } else {
            // exclude condition
            DP[n][w] = usingMemoizationKnapSack(value, weight, w, n - 1, DP);
            return DP[n][w];
        }
    }

    // using tabulation
    public static int TabulationKnapsack(int value[], int weight[], int w) {
        int n = value.length;
        int dp[][] = new int[n + 1][w + 1];

        // fill the 0th colum and oth row as 0
        // 0 th col
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // 0 th row
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        // i means number of items

        // and j means the max weight
        // (2, 3)
        // there will 0 1 2 items and weight is 3
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int v = value[i - 1]; // ith item value
                int ww = weight[i - 1];// ith item weight
                // valid
                if (ww <= j) {

                    int includeProfit = v + dp[i - 1][j - ww];
                    int excludeProfit = dp[i - 1][j]; // when the weigjt is greater then j
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                }
                // invalid condition
                else {
                    int excludeProfit = dp[i - 1][j];

                    dp[i][j] = excludeProfit;

                }
            }
        }
        print(dp);
        return dp[n][w];
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        System.out.println("using Recursion : " + knapsackFindMaxValue(value, wt, w, value.length));

        System.out.println("using tabulation : " + TabulationKnapsack(value, wt, w));
        int DP[][] = new int[value.length + 1][w + 1];
        for (int[] row : DP) {

            Arrays.fill(row, -1);
        }
        System.out.println("using Memoization : " + usingMemoizationKnapSack(value, wt, w, value.length, DP));

    }
}
