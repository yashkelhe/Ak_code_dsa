package bit_wise_operators;

// here cwe have to clear the range of bits for that n= 100111010011 ,and range is i= 2; j = 7; given 
// we have to make bitmask whcih gives me ouput output     100100000011
// for that we have divide into two parts a and b for a =  111100000000 , b = 000000000011 and when you do OR of this two you will get bitmask = 111100000011
// and the do  & of ( n & bitmask)

public class clear_range_of_bits {
    public static int clearRangeOfBits(int n, int i, int j) {
        int a = (~0) << j + 1;
        int b = (1 << i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(clearRangeOfBits(10, 2, 4));
        // 00001010
        // 76543210 index
        // 11100000
        // 00000011
        // 11100011
        // 00000010 -> 2
    }
}