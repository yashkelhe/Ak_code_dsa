import java.util.*;

public class circular_queue {

    static class queue {
        static int[] arr;
        static int size;
        // here both the veriable are varry at different position
        static int rear;
        static int front;

        queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // for the isEmpty O(1)
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // is full condition is like when the both the pointer are in some index then
        // its called full O(1)
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add O(1)
        public static void add(int data) {
            if (isFull()) {
                System.out.println("rear is full");
                return;
            }
            // add first element
            if (front == -1) {
                front = 0;
            }
            // update
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove O(1);
        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[front];
            // when the only last element is remaining and the queue becomes empty then we
            // have to make rear and front as the -1 ;
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // peek O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        queue q = new queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
