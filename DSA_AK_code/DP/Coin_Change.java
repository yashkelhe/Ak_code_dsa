package DP;

/*
 Given a set of coins of different denominations and a total amount (sum), find the number of distinct ways to make the amount using the coins.
You can use each coin an unlimited number of times 
 */
public class Coin_Change {
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static int UsingTabulation(int coins[], int sum) {
        int n = coins.length;

        int dp[][] = new int[n + 1][sum + 1];

        // then assign a meaning to the initialze
        for (int i = 0; i < n + 1; i++) {
            // why one because if sum is 0 then not coins will take means null and null also
            // count as one way
            dp[i][0] = 1;
        }
        // in the java the array is initialize with 0
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        // i -> coins , j -> sums
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {// valid
                    // why only the i because we are using the some coin again at row means single
                    // coin
                    // current ways + previous ways
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {// exclude condition
                    // previous ways
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];

    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3 };
        int arr[] = { 2, 5, 3, 8 };
        int sum = 10;

        System.out.println(UsingTabulation(arr, sum));
    }

}
