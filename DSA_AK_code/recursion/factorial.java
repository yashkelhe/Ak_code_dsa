public class factorial {
    public static int factorial( int n ){
    // base
    if( n == 0){
        return 1;
    }
    int fact2 = factorial( n - 1);
    int fact = n * factorial( n-1);
    return fact;
    // recursion function
    // work
    }
    public static void main(String[] args) {
        int n= 10;
         int a = factorial(n);
         System.out.println(a);
    }
}
