package delete;

// Given an integer,n, perform the following conditional actions:

// If n is odd, print Weird
// If n is even and in the inclusive range of 2 to 5, print Not Weird
// If n is even and in the inclusive range of 6 to 20, print Weird
// If n is even and greater than 20, print Not Weird

public class q1 {

    public static String tofind(int n) {

        if (n % 2 != 0) {
            return "weired";
        } else {
            if (2 <= n && n >= 5) {

                return "Not Weird";
            } else if (6 <= n && n <= 20) {
                return "weird";
            } else {
                return "Not Weird";
            }
        }

    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(tofind(n));
    }
}
