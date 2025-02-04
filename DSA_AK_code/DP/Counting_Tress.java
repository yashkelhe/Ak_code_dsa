package DP;

public class Counting_Tress {
    // O(n^2)
    public static int UsingTabulationBST(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int leftSubTree = dp[j];
                int RigSubTree = dp[i - j - 1];
                dp[i] += leftSubTree * RigSubTree;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(UsingTabulationBST(n));
    }

}
