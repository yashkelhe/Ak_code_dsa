package DP;

import java.util.Arrays;

public class Catalans_Number {
    public static int CalculateCatalansUsingRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += CalculateCatalansUsingRecursion(i) * CalculateCatalansUsingRecursion(n - i - 1);
        }

        return ans;
    }

    public static int usingMemorization(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += usingMemorization(i, dp) * usingMemorization(n - i - 1, dp);
        }

        return dp[n] = ans;

    }

    public static int usingTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("using the recursion : " + CalculateCatalansUsingRecursion(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("using memorization : " + usingMemorization(n, dp));

        int value = 4;
        System.out.println("using tabulation method : " + usingTabulation(value));
    }

}
