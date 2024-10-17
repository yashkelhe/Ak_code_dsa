package DP;

import java.util.Arrays;

public class Catalans_nber {
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

    public static void main(String[] args) {
        int n = 4;
        System.out.println("using the recursion : " + CalculateCatalansUsingRecursion(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("using memorization : " + usingMemorization(n, dp));
    }

}
