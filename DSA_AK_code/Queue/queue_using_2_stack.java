package Queue;

import java.util.*;

// question is queue using the 2 stack
public class queue_using_2_stack {
    static class queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {

            // here tow while are runnig so the time complextity will be the n + n = 2n O(n)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());

            }
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return s1.pop();
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {
        queue s = new queue();
        s.add(1);
        s.add(2);
        s.add(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.remove();
        }
    }
}