package sorting;

// here what we will do is we will take an smallest number form the array and   then  that number will be stored in the acending order 
// first we will instiallize the min element 
// also find the smallles number in the from the unsorted array the 
public class selection_sort {
    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minPos] > array[j]) {
                    minPos = j;
                }
            }
            int temp = array[minPos];
            array[minPos] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 4, 3, 1, 2 };
        selectionSort(array);
        printArray(array);
    }
}
