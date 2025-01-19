package DP;

public class Subsequence_Tabulation {
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static int tabulationLongestCount(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        // in the java we dont have to initialze the array with zero

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // it means that if the current matches means +1
                    // but we have to find the total number of the character which are matches
                    // so for previous output which dp[i - 1][j - 1] this
                    // lets take example current is b == b
                    // and previous was a == a then for that we just -1 from the current so we will
                    // get previouse value from table

                    // and why we havent use the dp[i][j - 1] or dp[i - 1][j] something like this
                    // represent that we are excluding the one of the string part
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int firstHalf = dp[i - 1][j];
                    int secondHalf = dp[i][j - 1];
                    dp[i][j] = Math.max(firstHalf, secondHalf);
                }
            }
        }
        print(dp);
        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(tabulationLongestCount(str1, str2));
    }
}
