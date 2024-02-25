package Queue;

public class Using_Array {
    static class queue {
        static int arr[];
        static int size;

        // here we have only take the rear pointer becouse of front pointer is fixed
        static int rear;

        // n is length
        queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // is#Empty TC O(1)
        public static boolean isEmpty() {
            return rear == -1;

        }

        // add TC O(1)
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("queue is fulll");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        // remove TC O(n) becouse we have to copy all the elements
        public static int remove() {
            if (isEmpty()) {
                System.out.println("the queue is enpty");
                return -1;
            }
            // front is fixed
            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear = rear - 1;
            return front;
        }

        // peek TC O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("the queue is enpty");
                return -1;
            }
            return arr[0];
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
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
