package divide_conquer;

public class Merge_sort {
    // to print the array

    public static void mergeSort(int array[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // first find the middle and then
        // sort the both the sides
        // then combine both sides
        int mid = si + (ei - si) / 2;
        System.out.println("si :" + si + " ei : " + ei + " mid : " + mid);
        mergeSort(array, si, mid);
        System.out.println("....si : " + si + " ei : " + ei + " mid : " + mid);
        mergeSort(array, mid + 1, ei);
        System.out.println("..........si : " + si + " ei : " + ei + " mid : " + mid);
        merge(array, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // Start of left subarray
        int j = mid + 1; // Start of right subarray
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements from the right subarray, if any
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray back into the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArray(int arra[]) {
        for (int i = 0; i < arra.length; i++) {
            System.out.print(arra[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}

// The merge sort algorithm employs a divide-and-conquer approach to efficiently
// sort an array. It begins by recursively dividing the array into halves until
// reaching base cases, where each subarray has only one element. As the
// recursion unwinds, the algorithm merges these sorted subarrays, combining
// them in a way that ensures the final result is a fully sorted array. This
// process continues until the entire original array is sorted. The algorithm's
// time complexity is O(n log n), making it efficient for large datasets. The
// key strength lies in its ability to maintain performance regardless of the
// input's initial order, providing a consistent and reliable sorting method.
