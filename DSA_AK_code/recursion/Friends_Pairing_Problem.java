package recursion;

// classical problem on  the recursion 
public class Friends_Pairing_Problem {
    public static int findTotalWayes(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // // when person wants to be signle
        // int Fm1 = findTotalWayes(n - 1);
        // // here person have paire with someone
        // int Fm2 = findTotalWayes(n - 2);

        // // here will be total number of paires
        // int toPair = (n - 1) * Fm2;

        // // total number of wayes to to paired with person
        // int totWayes = Fm1 + toPair;
        // return totWayes;

        // in simple way
        return findTotalWayes(n - 1) + (n - 1) * findTotalWayes(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(findTotalWayes(3));
    }

}
