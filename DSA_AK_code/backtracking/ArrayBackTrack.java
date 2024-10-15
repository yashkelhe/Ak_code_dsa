package backtracking;

public class ArrayBackTrack {

    public static void array(int[] arr, int i, int val) {
        // base
        if (i == arr.length) {
            printArray(arr);
            return;
        }
        // recursion; 

        arr[i] = val;
        array(arr, i + 1, val + 1); // here we call the function
        arr[i] = arr[i] - 2; // when call comes again from stack from the top then its called as backtraking

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        array(arr, 0, 1);
        printArray(arr);
    }
}
