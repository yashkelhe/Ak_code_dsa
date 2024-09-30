package DP;

import java.util.*;

public class Climbing_Stairs {
    // it takes the O(2^n)
    public static int countWays(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return countWays(n - 1) + countWays(n - 2);
    }

    // now its takes the O(n)
    public static int UsingMemoizationCountWays(int n, int ways[]) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (ways[n] != -1) {
            return ways[n];
        }
        // means addition of the 3 and 4
        ways[n] = UsingMemoizationCountWays(n - 1, ways) + UsingMemoizationCountWays(n - 2, ways);
        return ways[n];
    }

    // time Complexty is O(n)
    public static int TabulationCountWays(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // here when the i ==1 then the i-2 will be negative
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        // we get the
        // n=3 => 3 and n =4 => 5 and if add this u will get n=5 => 8
        System.out.println(countWays(n));

        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println("using memoization : " + UsingMemoizationCountWays(n, ways));
        System.out.println("using tabulation : " + TabulationCountWays(n));
    }
}