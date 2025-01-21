package DP;

import java.util.*;

public class Longest_Increasing_SubSequence {

    public static int lcs(int arr[], int arr2[]) {
        int dp[][] = new int[arr.length + 1][arr2.length + 1];

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    // then take the previouse count + new count

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    // if not then take the previous as its
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[arr.length][arr2.length];
    }

    public static int findIncreasingSubSequence(int arr[]) {
        // steps
        // first will take the unquie element from the array by creating the set
        // then we will store the all the unquie element to the array
        // then sort the array
        // then will calculate the LCS longest Common subsequence
        // in that if the some then increase the element value and reduce both the array
        // else check for the individual array element
        // and take the max one

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            System.out.println("found : " + arr2[i]);
            i++;
        }
        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println("max increasing sequence : - " + findIncreasingSubSequence(arr));
    }
}
