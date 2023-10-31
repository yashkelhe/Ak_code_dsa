package bit_wise_operators;

// check wheather the  number is even or oddEven
// using (&) operators
// see the LSB of the number in binary to git that by using bitmask 
// using 1 as a bitmask
public class oddEven {
    public static void odd_even(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 0) {
            // for even numbers
            System.out.println(" this is a even number :" + n);
        } else {
            System.out.println("this is a odd number :" + n);
        }
    }

    public static void main(String[] args) {
        odd_even(3);
        odd_even(1);
        odd_even(2);
    }
}
