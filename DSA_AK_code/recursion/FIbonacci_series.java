package recursion;

// 0,1,1,2,3,5,8,13

public class FIbonacci_series {
    public static int fibo(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        int fib = fibo(n - 2) + fibo(n - 1);

        return fib;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibo(n));
    }
}
