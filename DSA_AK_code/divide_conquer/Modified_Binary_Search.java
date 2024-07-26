package divide_conquer;

public class Modified_Binary_Search {
    public static int search(int arr[], int tar, int si, int ei) {
        // base condition
        if (si > ei) {
            return -1;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        if (tar == arr[mid]) {
            return mid;
        }
        // mid on l1 line
        // right part of the l1 line
        System.out.println("starting : "+si +" ending is : "+ ei +" mid : "+ mid );
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                return search(arr, tar, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int index = search(arr, target, 0, arr.length - 1);
        System.out.println(index);

    }

}