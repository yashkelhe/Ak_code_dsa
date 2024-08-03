package Graph;

public class Disjoint_Set_DS {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // initialize the parent with
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

    }

    public static int find(int x) {
        // we are finding the parent of parnet until we get the superme parent
        if (x == par[x]) {
            return x;
        }
        // optimization path compression
        // as we are again and again calling to the parent becouse of that we will store
        // the parent so we dont need to call the again and again
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            // we can also ddo this becouse rthe rank of the both is same
            // par[parA] = parB;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {

            par[parA] = parB;

        } else {

            par[parB] = parA;
        }

    }

    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }

}
