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

                    // if the string gets matched then dont do anything take the previous answer
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    // do the operation
                    // means str1 we are adding the one to it to make it, like str2
                    // in math how u can show that ur adding something +1
                    int add = dp[i][j - 1] + 1;

                    // we have to make the str1 like str2 then str2
                    // If you decide to remove a character from st1, it means you're matching the
                    // result of converting st1[0..i-2] with st2[0..j-1]
                    // and why plus one because we have to count the number of operation have done
                    int remove = dp[i - 1][j] + 1;

                    // If you decide to replace a character in st1 to match the character in st2, it
                    // means you're matching the result of converting st1[0..i-2] to st2[0..j-2].
                    int replace = dp[i - 1][j - 1] + 1;

                    // why min because we want optimize and minimum opetaion
                    dp[i][j] = Math.min(add, Math.min(remove, replace));
                }

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        // variation is asked in the accenture coding round
        System.out.println(findHowManyOperationRequired(str1, str2));
    }
}

// '' '' e x e c u t i o n
// '' 0 1 2 3 4 5 6 7 8 9
// i 1 1 2 3 4 5 6 6 7 8
// n 2 2 2 3 4 5 6 7 7 7
// t 3 3 3 3 4 5 5 6 7 8
// e 4 3 4 3 4 5 6 6 7 8
// n 5 4 4 4 4 5 6 7 7 7
// t 6 5 5 5 5 5 6 7 8 8
// i 7 6 6 6 6 6 6 6 7 8
// o 8 7 7 7 7 7 7 7 6 7
// n 9 8 8 8 8 8 8 8 7 6