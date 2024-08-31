package DP;

public class fibonacci {
    public static int fib(int n, int[] f) {
        // Base cases
        if (n == 0 || n == 1) {
            return n;
        }

        // If the value is already computed, return it
        if (f[n] != 0) {
            return f[n];
        }

        // Compute the value and store it in the array
        // 4 = 3 + 2 ;
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] f = new int[n + 1]; // Initialize the memoization array with default values of 0
        System.out.println(fib(n, f)); // Should print 5
    }
}
