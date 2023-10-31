package bit_wise_operators;

// clear the ith bit 
// i = 1
// n = 10 

// 1010 -> ( 10)
// 1101

// 1000 -> ( 8)

public class clear_ith_bit {
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(clearIthBit(10, 1));
    }
}
