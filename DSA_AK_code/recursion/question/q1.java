package recursion.question;

// For a given integer array of size N.You have to find all the occurrences(indices)of a give n element(Key)and print them.Use a recursive function to solve this problem. Sample Input: arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2},key = 2
// Sample Output: 1 5 7 8
public class q1 {
    public static void printOccurrences(int key, int[] arr, int i) {
        // base case

        if (i == arr.length) {
            return;
        }
        // kam
        if (key == arr[i]) {
            System.out.println(i);
        }
        printOccurrences(key, arr, i + 1);

    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        printOccurrences(2, arr, 0);
    }
}
