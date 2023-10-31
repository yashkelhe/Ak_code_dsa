package bit_wise_operators;

public class update_bit {
    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        // to return the value after seting the ith bit
        return n | bitmask;
    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    // approach one
    public static int updateBit(int n, int i, int newBit) {
        if (newBit == 1) {
            return setIthBit(n, i);
        } else {
            return clearIthBit(n, i);
        }
    }

    // approach second both are same
    public static int updateBit_second(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
    }

    public static void main(String[] args) {
        // approach one
        System.out.println(updateBit(10, 2, 1));
        // approach second both are same
        System.out.println(updateBit_second(10, 2, 1));
    }
}
