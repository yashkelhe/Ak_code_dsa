package sorting;
// in the selection sort there will have tow arraays which one us sroted and unother one is unsorted we will take on element from the  unsorted array then we compare with that element with the sorted array  like that we will do this for hole array

public class insertion_sort {
    public static void insertionSort(int[] array) {
        // we define first element as the sorted array
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int prev = i - 1;
            while (prev >= 0 && array[prev] > curr) {
                array[prev + 1] = array[prev];
                prev--;
            }
            array[prev + 1] = curr;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = { 6, 4, 5, 3, 2, 5, 1 };

        insertionSort(array);
        printArray(array);
    }
}