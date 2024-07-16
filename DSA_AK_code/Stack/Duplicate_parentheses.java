package Stack;

import java.util.*;

// and the time complexity is O(n);
public class Duplicate_parentheses {
    public static Boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing condition
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    // duplicate
                    return true;
                } else {
                    // to pop the pair open bracket '(';
                    s.pop();
                }
            } else {
                s.push(ch);

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(a+b)}";
        System.out.println(""+ str +" equestion has "+ isDuplicate(str)+" value");
    }
}
