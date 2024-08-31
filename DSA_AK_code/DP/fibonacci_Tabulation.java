package DP;

public class fibonacci_Tabulation {
    public static int tabulationMethodOFDP(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        // 0 to n which is n+1'
        int dp[] = new int[n + 1];

        // dp[0] = 0; this is by default
        dp[1] = 1;
        // this should be qual to the n becouse we are calcuklating up to n
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(tabulationMethodOFDP(7));
    }

}
