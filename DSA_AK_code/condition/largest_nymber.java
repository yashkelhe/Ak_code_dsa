package condition;

public class largest_nymber {
    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 7;

        if (a >= b && a >= c) {

            System.out.println("a");
        } else if (b >= a && b >= c) {
            System.out.println("b");
        } else {
            System.out.println("c");
        }
    }
}
