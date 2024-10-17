package DP;

public class wildCard_Matching {
    public static boolean findTheWildCardPattern(String str, String pattern) {
        // time complexity is O(n* m)
        int n = str.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        // initialize
        // when the pattern is empty
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        // when the string is empty butt he pattern has the *

        for (int j = 1; j < m + 1; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // now for the inner part
        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    // case 1 :if the pattern is* this and we have to find the squence of the char
                    // then we
                    // will just dp[i - 1][j] do this string will reduce but the pattern will be
                    // same and
                    // case 2 : if we want to ignore the * then dp[i][j - 1]
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    // if the char are not same
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        // String str = "baaabab";
        // String pattern = "*****ba*****ab";
        // System.out.println(findTheWildCardPattern(str, pattern)); // true
        String str = "abc";
        String pattern = "**d";
        System.out.println(findTheWildCardPattern(str, pattern)); // false
    }
}
