package recursion;

// find the first occurance in the array
public class first_occurance {
    public static int firstOccurance(int key, int arr[], int i) {
        // base case
        if (arr.length - 1 == i) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurance(key, arr, i + 1);
    }

    public static int lastOccurance(int key, int arr[], int i) {

        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(key, arr, i + 1);
        System.out.println("this is isFound" + isFound);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;

    }

    public static void main(String[] args) {
        int arr[] = { 9, 3, 4, 5, 8, 11, 6, 5, 5, 5, 8 };
        System.out.println(firstOccurance(5, arr, 0));
        System.out.println(lastOccurance(5, arr, 0));
    }
}

// Let's trace the call stack for lastOccurance(5, arr, 0):

// lastOccurance(5, arr, 0) is called from the main method.
// lastOccurance(5, arr, 0) checks if i == arr.length, which is false (i = 0,
// arr.length = 11).
// It makes a recursive call: lastOccurance(5, arr, 1).
// The recursive call continues until i reaches arr.length.
// During the recursive calls, each call to lastOccurance checks the condition
// and either makes further recursive calls or returns -1.
// When i = 11 (arr.length), the base case is reached, and -1 is returned to the
// previous call.
// The call stack is resolved backward:
// The call with i = 10 returns -1.
// The call with i = 9 returns -1.
// The call with i = 8 returns -1.
// ...and so on, until the original call with i = 0 resolves.
// The call stack shows the recursive calls and their return values until the
// original call to lastOccurance(5, arr, 0) is resolved.

// Return with Conditions:

// While unwinding the recursive calls (i.e., when returning back through the
// call stack), the code checks the condition arr[i] == key.
// This check occurs when the function is returning from the recursive calls and
// resolving their results.