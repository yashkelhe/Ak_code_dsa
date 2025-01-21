package DP;

public class Mountain_Ranges {

    // O(n^2)
    // catalans number
    public static int Mountain_Valleys(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int insideValleys = dp[j];
                int OutSideValleys = dp[i - j - 1];
                dp[i] += insideValleys * OutSideValleys;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Mountain_Valleys(n));
    }

}
