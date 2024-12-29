package recursion;

public class factorial {
    public static int factorial(int n) {
        // base
        if (n == 0) {
            return 1;
        }
        // work
        // recursion function

        int fact = n * factorial(n - 1);
        return fact;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(factorial(n));
    }
}
