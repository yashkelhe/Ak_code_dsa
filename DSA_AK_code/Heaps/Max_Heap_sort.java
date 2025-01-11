package Heaps;

// this will take the O(n log n)
public class Max_Heap_sort {

    public static void heapify(int arr[], int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIndex = index;// root

        // this is for the min heap which is for the dicsending
        // if (left < size && arr[left] < arr[maxIndex]) {

        // and this for the ascending order
        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }

        // this is for the min heap which is for the dicsending
        // if (right < size && arr[right] < arr[maxIndex]) {

        // and this for the ascending order
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(arr, maxIndex, size);
        }

    }

    public static void MaxHeapSort(int arr[]) {
        // there are two steps first to make the heap as max heap
        int n = arr.length;

        // the loop only will run on the uper side of the heap not a leaf elements
        for (int i = n / 2; i >= 0; i--) { // ( n log n)
            heapify(arr, i, n);
        }

        // step 2 is that add the max element to the last
        for (int i = n - 1; i > 0; i--) {
            // swape
            // first element of the max heap always maximum element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // heapify first arr , index basicly root ,size
            heapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 8, 5, 4 };

        MaxHeapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
 * Phase 1: Building the Max-Heap (First Loop):
 * 
 * In this phase, we start from the last non-leaf node (at index n/2 - 1) and
 * move up to the root, calling heapify on each node. This ensures the entire
 * array satisfies the max-heap property.
 * This loop only needs to process the non-leaf nodes because leaf nodes are
 * already valid heaps (a single node is trivially a heap).
 * Goal: Construct the initial max-heap, which is the foundation for sorting.
 * Phase 2: Extracting Maximum Elements (Second Loop):
 * 
 * Once the max-heap is built, the largest element (root of the heap) is swapped
 * with the last element in the unsorted portion of the array.
 * After the swap, the heap property is violated, so heapify is called on the
 * root to restore the max-heap property for the reduced heap.
 * This process is repeated for each element until the entire array is sorted.
 * Goal: Sort the array by repeatedly extracting the maximum element.
 */