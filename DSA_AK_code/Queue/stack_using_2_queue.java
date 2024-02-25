import java.util.*;

public class stack_using_2_queue {
    static class stack {
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

        public static int pop() {
            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }

            int top = -1;
            // Move elements from q1 to q2 until only one element is left in q1
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            // Retrieve the top element
            top = q1.remove();

            // Swap queues q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }

            int top = -1;
            // Move elements from q1 to q2 until only one element is left in q1
            while (!q1.isEmpty()) {
                top = q1.remove();
                q2.add(top);
            }

            // Swap queues q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return top;
        }
    }

    public static void main(String[] args) {
        stack q = new stack();
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
// The stack is implemented using two queues, q1 and q2, where q1 serves as the
// primary queue for storing elements. In the push(int data) method, when adding
// an element, it checks which queue is not empty and adds the element to that
// queue. For popping an element in the pop() method, elements are moved from q1
// to q2 until there's only one element left in q1, which represents the top
// element of the stack. This top element is removed and returned, and the
// queues are swapped to maintain the correct order. Similarly, in the peek()
// method, elements are moved from q1 to q2 until q1 becomes empty, allowing
// retrieval of the top element without removing it. Finally, the queues are
// swapped back to their original order. This approach ensures that the stack
// operations (push, pop, peek) have the correct behavior while utilizing two
// queues.