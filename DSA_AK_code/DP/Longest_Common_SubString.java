package DP;

public class Longest_Common_SubString {
    public static int LongestCommonSubString(String st1, String st2) {

        int n = st1.length();
        int m = st2.length();

        int dp[][] = new int[n + 1][m + 1];

        int Ans = 0;
        // first when one of the str is empty then initialze with 0 in tablulation
        // if both the char is some then reduce the string and then add +1 of both char
        // are some
        // else if the char is not equal to then Ans will be 0 then

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (st1.charAt(i - 1) == st2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    Ans = Math.max(Ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return Ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.print(LongestCommonSubString(str1, str2));// 2 longest common substring
    }
}
