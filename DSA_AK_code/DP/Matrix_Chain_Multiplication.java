
package DP;

import java.util.*;

public class Matrix_Chain_Multiplication {
    public static int mcmUsingRecursion(int arr[], int i, int j) {
        // base case
        if (i == j) {
            return 0; // when sigle matrix in remaining
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmUsingRecursion(arr, i, k); // Ai....Ak => arr[i-1] * arr[k]
            int cost2 = mcmUsingRecursion(arr, k + 1, j);// Ai+1.....Aj => arr[k] * arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static int mcmUsingMemoization(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            // when the only one matrix gets remaining ;
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmUsingMemoization(arr, i, k, dp);
            int cost2 = mcmUsingMemoization(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);

        }
        return dp[i][j] = ans;
    }

    public static int mcmTab(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                // for the cuts
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);

                }
            }

        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int n[] = { 1, 2, 3, 4, 3 };
        int nLength = n.length;
        // using the recursion
        System.out.println("the smalled cost is : " + mcmUsingRecursion(n, 1, nLength - 1));

        // Using the memoization it will go up the n-1
        int dp[][] = new int[nLength][nLength];
        for (int i = 0; i < nLength; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("using the  Tabulation smallest Value is : " + mcmTab(n));
        System.out.println("using the memoization smallest Value is : " + mcmUsingMemoization(n, 1, nLength - 1, dp));

    }

}
