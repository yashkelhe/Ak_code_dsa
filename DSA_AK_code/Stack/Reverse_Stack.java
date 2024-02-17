package Stack;

import java.util.*;

// reverse the stack  using stack 
public class Reverse_Stack {

    public static void insertAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        insertAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> ss) {
        while (!ss.isEmpty()) {
            System.out.print(ss.pop() + " ");

        }
    }

    public static void main(String[] args) {
        Stack<Integer> ss = new Stack<>();

        ss.push(1);
        ss.push(2);
        ss.push(3);
        // 3,2,1
        // 1,2,3
        // print Stack(ss);
        reverseStack(ss);
        printStack(ss);

    }

}