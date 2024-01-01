package recursion;

public class find_power {


    // this take O(n) time cimplexity which is not good for the large number
    public  static int power( int x, int n){
        if( n ==0){
            return 1 ;
        }
        // int p = power( x , n-1);
        // int xn = x* p;
        // return xn ;

        // we should have faith that the function will going to give you n-1 power 
        return x* power (x, n-1);
    }


    // we can do in the  O( log n) which means half of the privouse one
public static int optimizeWay( int x, int n ){
    if ( n == 0 ){
        return 1 ;}
        // int HalfPower = power(x , n / 2) *power(x , n / 2) ;
         int Half = power(x , n / 2)  ;
         int HalfPower=  Half*Half;



        // and for the even number  we will  just return the halfpower
        // and for the odd number we will again multiple the x with halfpower
        if( n  % 2 != 0 ){
            return x * HalfPower;
        } 

        return HalfPower;
}

    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(optimizeWay(2, 10));
    }
}
