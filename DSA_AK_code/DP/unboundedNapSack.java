package DP;

// O(n)
// just we have to make changes in the "i" which is current value rather then i-1
public class unboundedNapSack {
    public static int Unbounded(int value[], int weight[], int w) {
        int n = value.length;
        int dp[][] = new int[n + 1][w + 1];

        // fill the 0th colum and oth row as 0
        // 0 th col

        /*
         * for (int i = 0; i < dp.length; i++) {
         * dp[i][0] = 0;
         * }
         * // 0 th row
         * for (int i = 0; i < dp[0].length; i++) {
         * dp[0][i] = 0;
         * }
         * 
         */
        // i means number of items
        // and j means the max weight
        // (2, 3)
        // there will 0 1 2 items and weight is 3
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                // valid
                // current weight is less then j then valid
                if (weight[i - 1] <= j) {
                    // we are using the some value again, so we are checking the current weight

                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                }
                // invalid condition
                else {
                    // exclude take the previouse value
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }
        print(dp);
        return dp[n][w];
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        System.out.println(Unbounded(value, wt, w));
    }

}
