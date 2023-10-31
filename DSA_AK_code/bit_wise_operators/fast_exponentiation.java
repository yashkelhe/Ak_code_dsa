package bit_wise_operators;

// 5^2 
// time complexity will be O(log n)
public class fast_exponentiation {
    public static int exponentiation(int a, int n) {

        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) { // cheack LSb
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(exponentiation(5, 2));
    }
}
