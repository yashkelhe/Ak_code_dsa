package Stack;

import java.util.*;

public class Stack_Using_java_collection_framWork {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
