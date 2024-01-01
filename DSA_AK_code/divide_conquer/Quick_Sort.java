package divide_conquer;

public class Quick_Sort {

    public static void printArray(int arr[]) {

        for (int j = 0; j <= arr.length - 1; j++) {
            System.out.print(arr[j] + " ");
        }

    }

    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        int pivot = partition(arr, si, ei);
        quickSort(arr, si, pivot - 1);
        quickSort(arr, pivot + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        // last element as pivot
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5, -5 };
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
