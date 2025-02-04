package DP;

public class Target_sum_subsets {

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static boolean targetSumSubsets(int arr[], int sum) {
        int n = arr.length;

        boolean dp[][] = new boolean[n + 1][sum + 1];

        // now the base case is when the sum is 0 and element can be any then there will
        // be no element will go inside so for zero value its true

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        // and the other for the i = 0 and j up to the sum +1 ; will be defaault false
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];
                // include

                // dp[i-1][j-v] will check that the value which we have substracted from the
                // sum is eual to the zero means a case which gives the true
                // to check the previouse value after substracting

                // we have to check that the in the array have the numbers which is equal to the
                // sum
                // so for that if we are subtracting the current value then there should another
                // value which make that value as zeroso that is why we are check the back value
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                // if the value which is not contributing but still the value is true then its
                // true
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;

                }
                // and we dont need to make it false becouse in java the array already
                // initialize with the false
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int sum = 10;

        System.out.println("the target of the sum is present in the arrray :  " + targetSumSubsets(arr, sum));
    }

}
