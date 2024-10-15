package DP;

public class Subsequence {
    public static int longestSubstringCount(String str1, String str2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return longestSubstringCount(str1, str2, i - 1, j - 1) + 1;
        } else {
            int firsthalf = longestSubstringCount(str1, str2, i - 1, j);
            int secondthalf = longestSubstringCount(str1, str2, i, j - 1);
            return Math.max(firsthalf, secondthalf);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(longestSubstringCount(str1, str2, str1.length(), str2.length()));

    }
}
