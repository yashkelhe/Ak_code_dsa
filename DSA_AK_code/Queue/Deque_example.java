package Queue;

import java.util.*;

public class Deque_example {
    public static void main(String[] args) {
        // Create a Deque of Integers using LinkedList implementation
        Deque<Integer> q = new LinkedList<>();
        // Add elements to the deque
        q.addFirst(1); // Adds 1 at the beginning of the deque
        q.addLast(72); // Adds 72 at the end of the deque
        q.addLast(72); // Adds another 72 at the end of the deque
        q.addLast(72); // Adds another 72 at the end of the deque
        q.addLast(72); // Adds another 72 at the end of the deque

        // Print the deque
        System.out.println(q); // Output: [1, 72, 72, 72, 72]

        // Remove elements from the deque
        q.removeFirst(); // Removes the first element (1) from the deque
        q.removeLast(); // Removes the last element (72) from the deque

        // Print the deque after removal
        System.out.println(q); // Output: [72, 72, 72]

        // Print the first and last elements of the deque
        System.out.println(q.getFirst()); // Output: 72
        System.out.println(q.getLast()); // Output: 72
    }
}
