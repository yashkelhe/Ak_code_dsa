import java.util.*;

public class Deque_Using_Stack {
    static class Stack {
        Deque<Integer> de = new LinkedList<>();

        public void add(int data) {
            de.addLast(data);
        }

        public int remove() {
            return de.removeLast();
        }

        public int peek() {
            return de.getLast();
        }

    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.add(1);
        st.add(12);
        st.add(122);
        st.add(1222);
        System.out.println(st.peek());
        System.out.println(st.remove());
        System.out.println(st.peek());

    }

}
