package recursion;

public class factorial {
    public static int factorial(int n) {
        // base
        if (n == 0) {
            return 1;
        }
        // work
        // recursion function
        int fact2 = factorial(n - 1);
        int fact = n * fact2;
        return fact;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(factorial(n));
    }
}
