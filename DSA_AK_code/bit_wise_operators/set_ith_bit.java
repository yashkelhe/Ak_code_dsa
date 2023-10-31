package bit_wise_operators;

// we have to set the ith bit  
// we will do OR of n bit and bitmask 

// i= 2 
// n= 10 

// 1010
// 0100
// OR
// 1110  -> (14)
public class set_ith_bit {
    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        // to return the value after seting the ith bit
        return n | bitmask;
    }

    public static void main(String[] args) {
        System.out.println(setIthBit(10, 2));
    }
}
