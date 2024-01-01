package backtracking;

public class Grid {

    public static int totalWays(int i, int j, int n, int m) {

        // base
        if (i == n - 1 && j == m - 1) { // condition for last cell
            return 1;
        } else if (i == n || j == m) { // condition for boundary cross cell
            return 0;
        }
        // recurstion
        // down
        int w1 = totalWays(i + 1, j, n, m);

        // right
        int w2 = totalWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static int optimizeWay(int n, int m) {
        // base
        if (n == 0 || m == 0) {
            return 1;
        }

        // recurstion
        int w1 = n * optimizeWay(n - 1, m);
        int w2 = m * optimizeWay(n, m - 1);
        int sum = w1 + w2;
        return sum / w1 * w2;

    }

    public static void main(String[] args) {
        int n = 3, m = 3;

        // here Time complexity will be O(2^n+m) which is exponential ,to bad
        System.out.println(totalWays(0, 0, n, m));

        // here Time complexity will be O(n)
        System.out.println(optimizeWay(n, m));
    }
}
