package backtracking;

// n! will be the permutation
public class permutation {
    public static void permut(String str, String ans) {
        // base
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" => "ab"+ "de" = "abde"
            // substring(0, i-1)
            String NewStr = str.substring(0, i) + str.substring(i + 1);
            permut(NewStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        permut(str, "");
    }
}

// permut("abc", "")
// First iteration of the for loop with i = 0:

// permut("bc", "a")

// Second iteration of the for loop with i = 0:

// permut("c", "ab")

// Third iteration of the for loop with i = 0:

// permut("", "abc")
// Base case reached, prints "abc"
// Second iteration of the for loop with i = 1:

// permut("b", "ac")

// Third iteration of the for loop with i = 0:

// permut("", "acb")
// Base case reached, prints "acb"
// First iteration of the for loop with i = 1:

// permut("ac", "b")

// Second iteration of the for loop with i = 0:

// permut("c", "ba")

// Third iteration of the for loop with i = 0:

// permut("", "bac")
// Base case reached, prints "bac"
// Second iteration of the for loop with i = 1:
        
// permut("a", "bc")

// Third iteration of the for loop with i = 0:

// permut("", "bca")
// Base case reached, prints "bca"
// First iteration of the for loop with i = 2:

// permut("ab", "c")

// Second iteration of the for loop with i = 0:

// permut("b", "ca")

// Third iteration of the for loop with i = 0:

// permut("", "cab")
// Base case reached, prints "cab"
// Second iteration of the for loop with i = 1:

// permut("a", "cb")

// Third iteration of the for loop with i = 0:

// permut("", "cba")
// Base case reached, prints "cba"
// This exhausts all possible permutations of the string "abc", resulting in the
// output of all permutations: "abc", "acb", "bac", "bca", "cab", "cba".
