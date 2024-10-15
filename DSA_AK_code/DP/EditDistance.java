package DP;

public class EditDistance {
    public static int findHowManyOperationRequired(String st1, String st2) {

        // first we have to initialze the
        // table by if there is empty str1 and u have to convert into the str2 then u
        // will required the str1.length opertion to convert
        // then if the char is same dont do just reduce the string and check the next
        // char
        // else then use the oprtation

        int n = st1.length();
        int m = st2.length();

        int dp[][] = new int[n + 1][m + 1];

        // initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i][j - 1] + 1;
                    int remove = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(add, Math.min(remove, replace));
                }

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";

        System.out.println(findHowManyOperationRequired(str1, str2));
    }
}
