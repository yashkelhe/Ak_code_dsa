package DP;

public class Rod_Cutting {

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public int maxValueofRod(int rodMax, int lth[], int[] value) {
        int n = lth.length;
        int dp[][] = new int[n + 1][rodMax + 1];

        // in the java we dont have to specified the zero value for the specficed
        // element
        for (int i = 0; i < lth.length + 1; i++) {
            for (int j = 0; j < rodMax + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < lth.length + 1; i++) {
            for (int j = 1; j < rodMax + 1; j++) {
                // for the include case
                // if the current length is less then rod length then cut it
                if (lth[i - 1] <= j) {
                    // why max because i want a max value
                    // and here we can take the same length of as many times so dp[i][j-lth[i-1]]
                    // Math.max(current profit + previous profit)
                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - lth[i - 1]], dp[i - 1][j]);

                } else {
                    // previous profit
                    dp[i][j] = dp[i - 1][j];
                }

                // and for the exclude case
            }
        }
        print(dp);
        return dp[lth.length][rodMax];
    }

    public static void main(String args[]) {
        Rod_Cutting any = new Rod_Cutting();

        // int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        // int rodSize = 8;
        int length[] = { 1, 2, 3 };
        int price[] = { 8, 3, 5 };
        int rodSize = 6;
        System.out.println(any.maxValueofRod(rodSize, length, price));
    }

}
