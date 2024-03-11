import java.util.*;

// here we are making the queue using the two stack
public class stack_using_2_queue {
    static class Stack {
        // create tow queue
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            // Add the element to the non-empty queue
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // TC(1) for the pop function

        public static int pop() {
            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }

            int top = -1;

            // case 1
            if (!q1.isEmpty()) {

                while (!q1.isEmpty()) {
                    top = q1.remove();

                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // case2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }

            int top = -1;
            // Move elements from q1 to q2 until only one element is left in q1

            // case 1
            if (!q1.isEmpty()) {

                while (!q1.isEmpty()) {
                    top = q1.remove();

                    q2.add(top);
                }
            } else { // case2
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {
        Stack q = new Stack();
        q.push(1);
        q.push(2);
        q.push(3);
        // 3 2 1

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.pop();
        }
    }
}