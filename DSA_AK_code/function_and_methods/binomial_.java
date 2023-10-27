package function_and_methods;

public class binomial_ {

    public static int factorial(int a) {
        int b = 1;
        for (int i = a; i >= 1; i--) {
            b = b * i;
        }
        return b;
    }

    public static int binCoiff(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);
        int binomial = fact_n / (fact_r * fact_nmr);
        return binomial;
    }

    public static void main(String[] args) {

        System.out.println(binCoiff(5, 2));

    }
}
