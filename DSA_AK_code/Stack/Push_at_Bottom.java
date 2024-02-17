package Stack;

import java.util.*;

public class Push_at_Bottom {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // first we will check that the weather stack is empty or not if yes then jus
        // append the data
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // we will use the recursion to find the bottom
        // and this recursion will pop the all the elements wich are in the stack and
        // then just append the data
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        int data = 8;
        pushAtBottom(s, data);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
