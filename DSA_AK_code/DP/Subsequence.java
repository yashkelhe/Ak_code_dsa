package DP;

public class Subsequence {
    public static int longestSubstringCount(String str1, String str2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            // why plus one because got the first charcter and we are calling the next char
            return longestSubstringCount(str1, str2, i - 1, j - 1) + 1;
        } else {
            // if both are not matching means there another charter is present
            // then first check the next charcter of the first string is it matching with
            // the current charcter if yes then it will return the + 1
            int firsthalf = longestSubstringCount(str1, str2, i - 1, j);

            // and first half doesnot get matched then in second half check the next char of
            // the string2 with current charcter of the string1
            // if matched then return + 1
            int secondthalf = longestSubstringCount(str1, str2, i, j - 1);

            // koi too + 1 return karega
            return Math.max(firsthalf, secondthalf);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(longestSubstringCount(str1, str2, str1.length(), str2.length()));

    }
}
