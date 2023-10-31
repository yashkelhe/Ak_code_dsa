package bit_wise_operators;

// here we have to find the ith bit is 0 or 1 

// here we are doing bitmask  
// and the bitmask is 1<<i 
// then do ( & ) between i & bitmask

//   i= 2;
// number
//   n = 1111 -> (15)
// bitmask
//   0100
// then do ( & )
// output is : 0100

public class ith_bit_bitmask {
    public static int ith_bit(int i, int n) {
        int bitmask = 1 << i;
        if ((n & bitmask) != 0) {
            // odd numbers
            return 1;
        } else {
            // even numbers
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(ith_bit(2, 15));

    }
}
