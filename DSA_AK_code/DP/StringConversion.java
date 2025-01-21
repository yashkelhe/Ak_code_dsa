package DP;

public class StringConversion {
    public static int findTheNumberOfOperationRequired(String str, String str2) {
        int lcs = LCS(str, str2);

        int delete = str.length() - lcs; // Characters to be deleted from str
        int toBeAdded = str2.length() - lcs; // Characters to be added to match str2
        return delete + toBeAdded;
    }

    public static int LCS(String str, String str2) {
        int n = str.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // we are adding the in the str1
                    int insert = dp[i][j - 1];
                    // we are deleting from the str1 to match with str2
                    // means if we take the opertion which dp[i - 1][j] which is already matched
                    // then it means we have matched with it + 1 for the opertion
                    // //////////////////
                    // After removing 't', st1 becomes "ca", and now you need to figure out the cost
                    // of converting "ca" to "cut"
                    int delete = dp[i - 1][j];
                    // we want number of del an ins means all
                    dp[i][j] = Math.max(delete, insert);
                }
            }
        }
        return dp[n][m]; // Return the length of LCS

    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";
        System.out.println(findTheNumberOfOperationRequired(str1, str2)); // Output should be 4
    }
}
