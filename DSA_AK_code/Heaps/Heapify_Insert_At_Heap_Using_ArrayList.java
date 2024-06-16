package Heaps;

import java.util.*;

public class Heapify_Insert_At_Heap_Using_ArrayList {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // O(log n)
        public void add(int data) {

            // add the data at last
            arr.add(data);

            // position of the inserted element
            int x = arr.size() - 1;
            // find the parent position
            int parent = (x - 1) / 2;
            // for max heap
            // if (arr.get(x) > arr.get(parent)) {
            if (arr.get(x) < arr.get(parent)) {
                // swap the element
                int temp = arr.get(x);
                // arr.set swap the element in the arrayList
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent;
                parent = (x - 1) / 2;
            }

        }

        // O(1)
        public int peek() {
            return arr.get(0);
        }

        // heapify
        private void heapify(int index) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int minIndex = index;
            // for max heap
            // if (arr.size() > left && arr.get(minIndex) < arr.get(left)) {
            if (arr.size() > left && arr.get(minIndex) > arr.get(left)) {
                minIndex = left;
            }
            // for max heap
            // if (arr.size() > right && arr.get(minIndex) < arr.get(right)) {
            if (arr.size() > right && arr.get(minIndex) > arr.get(right)) {
                minIndex = right;
            }

            // index is changed
            if (minIndex != index) {
                int temp = arr.get(index);
                arr.set(index, arr.get(minIndex));
                arr.set(minIndex, temp);
                heapify(minIndex);
            }
        }

        public int remove() {
            // for to return the index value
            int data = arr.get(0);

            // swap
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // and then remove the element
            arr.remove(arr.size() - 1);

            // step3 -heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        System.out.println("min heap  ");
        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
