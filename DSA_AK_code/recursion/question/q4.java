package recursion.question;

// find a substring of the string

// "Given a string S, we need to find the count of all contiguous substrings starting and ending with the same character.
// For example:
// Sample Input 1: S = 'abcab'
// Sample Output 1: 7
// Explanation:
// For the string 'abcab', there are 15 substrings: 'a', 'ab', 'abc', 'abca', 'abcab', 'b', 'bc', 'bca', 'bcab', 'c', 'ca', 'cab', 'a', 'ab', 'b'.
// Out of these substrings, 7 of them start and end with the same character: 'a', 'abca', 'b', 'bcab', 'c', 'a', and 'b'. Therefore, the output is 7.

// Sample Input 2: S = 'aba'
// Sample Output 2: 4

// Explanation:
// For the string 'aba', the substrings are: 'a', 'b', 'a', and 'aba'. Out of these, 4 of them start and end with the same character: 'a', 'b', 'a', and 'aba'. Hence, the output is 4."
public class q4 {
    // yash

    public static int countSubstrs(String str, int i, int j, int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int res = countSubstrs(str, i + 1, j, n - 1) + countSubstrs(str, i, j - 1, n - 1)
                - countSubstrs(str, i + 1, j - 1, n - 2);
        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcab";
        int n = str.length();
        System.out.print(countSubstrs(str, 0, n - 1, n));
    }

}