package bit_wise_operators;

// here we want to clear all the last ith bit for that we have taken{  (-1) = (~0) = (111111111)}

// (-1)<< i
// 11111<<2
// 11100

// then 
// n = 1111
// bitmask = 1100

// &
// 1100 -> 12

public class clear_last_ith_bits {

    public static int clear_last_ith(int n, int i) {
        int bitmask = (~0) << i;// 1 <<2 => 1100
        return n & bitmask; // 1111 & 1100=1100
    }

    public static void main(String[] args) {
        System.out.println(clear_last_ith(15, 2));
    }
}