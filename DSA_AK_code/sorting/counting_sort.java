package sorting;

// first we will intiallize the a lasrgest number and then the length of the  frequency array largest+1 
// count sort mostly used for the positive numbers
public class counting_sort {
    public static void counting(int array[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            largest = Math.max(largest, array[i]);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        // sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 3, 25, 5, 1, 0, 1 };
        counting(array);
        printArray(array);
    }

}
