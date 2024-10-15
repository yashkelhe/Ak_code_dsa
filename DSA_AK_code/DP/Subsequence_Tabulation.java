package DP;

public class Subsequence_Tabulation {
    public static int tabulationLongestCount(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        // in the java we dont have to initialze the array with zero

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int firstHalf = dp[i - 1][j];
                    int secondHalf = dp[i][j - 1];
                    dp[i][j] = Math.max(firstHalf, secondHalf);
                }
            }
        }
        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(tabulationLongestCount(str1, str2));
    }
}
