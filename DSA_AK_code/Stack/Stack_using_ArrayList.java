package Stack;

import java.util.ArrayList;

public class Stack_using_ArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        // for to cheak the weather stack is empty or not

        public static Boolean isEmpty() {
            return list.size() == 0;
        }

        // push O(1)
        public static void push(int data) {
            list.add(data);
        }

        // pop take O(1)
        public static int pop() {
            // cornar case case when statc empty
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek take O(1)
        public static int peek() {
            // cornar case case when statc empty
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
