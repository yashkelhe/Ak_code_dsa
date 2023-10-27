package array;

// and the time complexity of the ninary search is { O(log n) }
public class binary_search {
    public static int binarySearch(int num[], int key) {
        int start = 0;
        int end = num.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] == key) {
                return mid;
            } else if (num[mid] > key) {
                end = mid - 1;
            } else if (num[mid] < key) {
                start = mid + 1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        int num[] = { 1, 2, 3, 4, 5 };
        int key = 28;
        System.out.println("index for key is : " + binarySearch(num, key));
    }
}
