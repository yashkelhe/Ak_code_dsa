import java.util.Arrays;

// Question:
// Given a string of size N consisting of 'L' and 'R' characters, where there is an equal number of 'L's and 'R's, the task is to find the maximum number of partitions X such that the given string can be partitioned into X balanced substrings. A string is considered balanced if the number of 'L's in the string equals the number of 'R's.
public class lexicographically_smallest {
    public static char[] lexo_small(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a'); // Initialize the array with 'a's
        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            k -= i; // Subtract i from k
            // Check if k is non-negative
            if (k >= 0) {
                // If k is greater than or equal to 26, set current character to 'z'
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    // Otherwise, set current character to character corresponding to k
                    arr[i] = (char) (k + 97 - 1); // 'a' has ASCII value of 97
                    k -= arr[i] - 'a' + 1;
                }
            } else {
                // If k becomes negative, break out of the loop
                break;
            }
            // Add i back to k for next iteration
            k += i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 5; // Length of the string
        int k = 42; // Sum of distances between consecutive characters
        char arr[] = lexo_small(n, k);
        System.out.print(new String(arr));
    }
}
