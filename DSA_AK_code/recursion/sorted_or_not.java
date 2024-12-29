package recursion;

public class sorted_or_not {

    public static boolean isSorted(int arr[], int i) {
        // first base case
        // length of it
        if (arr.length - 1 == i) {
            return true;
        }
        // if current idnex is greater then the next then its false
        if (arr[i] >= arr[i + 1]) {
            // we can do swaping here if we want to sort this
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int[] MakeSorted(int arr[], int i) {
        // first base case
        // length of it
        if (i == arr.length - 1) {
            return arr;
        }
        // if current idnex is greater then the next then its false
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return MakeSorted(arr, i + 1);
    }

    public static void main(String[] args) {
        int arrr[] = { 1, 2, 8, 4, 5 };
        System.out.println(isSorted(arrr, 0));
        MakeSorted(arrr, 0);
        for (int i = 0; i < arrr.length; i++) {
            System.out.println(arrr[i]);
        }
    }
}