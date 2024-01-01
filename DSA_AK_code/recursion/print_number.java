package recursion;

public class print_number {
    // print numbers in ascending order
    public static void decreasing(int n) {
        // base condition
        if (n == 1) {
            System.out.println(n);
            return;
        } // work
        System.out.println(n + " ");
        // recursive function
        decreasing(n - 1);
    }
    // print numbers in inceasing order

    public static void inceasing(int n) {
        // base condition
        if (n == 1) {
            System.out.println(n);
            return;
        }
        // recursive function

        // here will be
        // idhar first ye 10 to 1 take jayehga or jub ye return hoga tabe eke ek number
        // print karega
        inceasing(n - 1);
        // work
        // idhar jub ye recursion function resolve hoga means jub ye base condition ko
        // reach karega and retrun hoga tab ye print statment use hogi like from uper
        // side of the call stack like 1 2 3 4 5 6 7 8 9 10
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 10;
        decreasing(n);
        System.out.println();
        inceasing(n);

    }
}
