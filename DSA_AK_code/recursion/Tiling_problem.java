package recursion;

// problem number 11

// floor size is 2 * n 
// and each tilies size is 2* 1 
public class Tiling_problem {
    public static int tillingProblm(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1
        }

        // // kam
        // // horizontal
        // int hori = tillingProblm(n-2);
        // // vertical
        // int ver = tillingProblm(n-1);
        // int Total = hori + ver;
        // return Total;

        return tillingProblm(n - 2) + tillingProblm(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("total Number of wayes to add tilies are :" + tillingProblm(4));
    }
}

// two choice weather hori(n-2) or verti (n-1)