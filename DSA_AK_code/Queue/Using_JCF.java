package Queue;

import java.util.*;

public class Using_JCF {
    public static void main(String[] args) {
        // Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        // wwhy we are using the LinkedList becouse the queue is the interface so we
        // canot make object of it so for the implementation we take help of the
        // LinkedList and Arraydeque for to implement the Queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
