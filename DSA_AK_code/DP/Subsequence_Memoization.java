package DP;

public class Subsequence_Memoization {
    public static int longestSubstringCount(String str1, String str2, int i, int j, int dp[][]) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            // if gets matched then call to next character and why + 1 because we get the
            // matched the character

            return dp[i][j] = longestSubstringCount(str1, str2, i - 1, j - 1, dp) + 1;
        } else {
            // if not then check next char of the str1 and current char of the str2
            // and in the second half check next char of the str2 and current char of the
            // str1
            int firsthalf = longestSubstringCount(str1, str2, i - 1, j, dp);
            int secondthalf = longestSubstringCount(str1, str2, i, j - 1, dp);
            return dp[i][j] = Math.max(firsthalf, secondthalf);
        }

    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(longestSubstringCount(str1, str2, str1.length(), str2.length(), dp));
    }
}
