package backtracking.Question;

// Given a string containing digits from 2 to 9 inclusive, print all possible letter combinations that the number could represent. You can print the answer in any order. A mapping of digit to letters (similar to telephone buttons) is given below. Note that 1 does not map to any letters.

// 2 -> "abc"
// 3 -> "def"
// 4 -> "ghi"
// 5 -> "jkl"
// 6 -> "mno"
// 7 -> "pqrs"
// 8 -> "tuv"
// 9 -> "wxyz

// bfs(0, 1, new StringBuilder(), "2")
// Recursive Calls (Inside bfs):

// bfs(1, 1, new StringBuilder("a"), "2")
// bfs(1, 1, new StringBuilder("b"), "2")
// bfs(1, 1, new StringBuilder("c"), "2")
public class keyBoard_combination {
    // Define a static keypad mapping of numeric digits to corresponding letters
    final static char[][] L = {
            {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
    };

    // Method to generate letter combinations from a numeric string
    public static void letterCombinations(String D) {
        int len = D.length();
        if (len == 0) {
            System.out.println("");
            return;
        }
        bfs(0, len, new StringBuilder(), D);
    }

    // Recursive method using breadth-first search to generate combinations
    public static void bfs(int pos, int len, StringBuilder sb, String D) {
        if (pos == len) {
            System.out.println(sb.toString());
        } else {
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for (int i = 0; i < letters.length; i++) {
                bfs(pos + 1, len, new StringBuilder(sb).append(letters[i]), D);
            }
        }
    }

    // Main method to test letterCombinations method
    public static void main(String args[]) {
        letterCombinations("2"); // Initiates the letter combination generation for numeric string "2"
    }
}