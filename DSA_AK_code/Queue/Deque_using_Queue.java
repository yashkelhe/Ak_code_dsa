import java.util.*;

// public class Queue {
//     Deque<Integer> De = new LinkedList<>();

//     public void add(int data) {
//         De.addLast(data);
//     }

//     public int remove() {
//         return De.removeFirst();
//     }

//     public int peek() {
//         return De.getFirst();
//     }
// }
public class Deque_using_Queue {
    public static class Queue {
        Deque<Integer> De = new LinkedList<>();

        public void add(int data) {
            De.addLast(data);
        }

        public int remove() {
            return De.removeFirst();
        }

        public int peek() {
            return De.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(2);
        q.add(1);
        q.add(3);
        q.add(4);

        System.out.println("peek " + q.peek());
        System.out.println("remove " + q.remove());
        System.out.println("peek " + q.peek());
        System.out.println("remove " + q.remove());
        System.out.println("peek " + q.peek());
    }
}
