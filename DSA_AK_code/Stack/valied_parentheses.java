package Stack;

import java.util.*;

public class valied_parentheses {
    public static Boolean isValied(String str) {
        // create a stack
        Stack<Character> s = new Stack<>();
        // this loop will go up to the lenght of the string and take one by one char and
        // then cheak weather a open braket or closing braket if open then just push
        // else cheack the open brakets and closing brakets are matching then just
        // remove the open brakets
        for (int i = 0; i < str.length(); i++) {
            // first take character
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return true;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }

            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String para = "[([{}])][]";
        System.out.println(isValied(para));
    }
}
