package bit_wise_operators;
// setbit= 1 

// we have count how many setbits are in the number 

// by just douing right sift we will get  lsb

public class count_set_bit {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(10));
        // 10 -> 1010
        // setbits are -> 2
    }
}
