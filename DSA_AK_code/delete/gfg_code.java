package delete;
// Given an array of N integers, find the sum of xor of all pairs of numbers in the array arr. In other words, select all possible pairs of i and j from 0 to N-1 (i<j) and determine sum of all (arri xor arrj).

public class gfg_code {
    public static long sumXOR(int arr[], int n) {
        // Complete the function
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                n += arr[i] ^ arr[j];
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 9, 7, 6 };
        System.out.println(sumXOR(arr, 0));
    }
}
