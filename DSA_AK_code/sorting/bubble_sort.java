package sorting;
// in the bubble sort we have to swappe the next element with privouse element if when the privouse element is small and until we get sorted array 

// the first array will goes to i =0 to n-1
// and inner loop will goes to the j=0 to n-1-i
    //  TC O(n^2)
public class bubble_sort {
    public static void bubbleSort(int[] array_sorting) {
        int swapp = 0;
         //the length of the array 4
        // it will  go upto  2 
        for (int turn = 0; turn < array_sorting.length - 1; turn++) {
            // it will  go upto  -1-1 = -2 
            for (int j = 0; j < array_sorting.length - 1 - turn; j++) {
                if (array_sorting[j] > array_sorting[j + 1]) {
                    // the swappe it
                    int temp = array_sorting[j];
                    array_sorting[j] = array_sorting[j + 1];
                    array_sorting[j + 1] = temp;
                    swapp++;
                }
            }
        }
        System.out.println("it takes this much itration : " + swapp);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array ={ 5, 2, 3, 4,  1 };
        bubbleSort(array);
        printArray(array);
    }

}
