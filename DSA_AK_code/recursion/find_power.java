package recursion;

public class find_power {

    // this take O(n) time cimplexity which is not good for the large number
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // int p = power( x , n-1);
        // int xn = x* p;
        // return xn ;

        // we should have faith that the function will going to give you n-1 power
        return x * power(x, n - 1);
    }

    // we can do in the O( log n) which means half of the privouse one
    public static int optimizeWay(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // int HalfPower = power(x , n / 2) *power(x , n / 2) ;
        // after hitting to the base case it will assign the 1 to the half
        // at n = 1
        int Half = power(x, n / 2);
        int HalfPower = Half * Half;

        // and for the even number we will just return the halfpower
        // and for the odd number we will again multiple the x with halfpower

        // after hitting this return to that backtrack iteration
        if (n % 2 != 0) {
            // if the n is off then it will return and value will be stored in the half as
            // backtrack
            return x * HalfPower;
        }
        // if not then return as its for the even
        return HalfPower;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(optimizeWay(2, 10));
    }
}
