package array;
// Integer.MAX_VALUE   is infinite

// Integer.MIN_VALUE   is negative infinite

public class largest_number {
    public static int largestnumber(int num[]) {
        int largest = Integer.MIN_VALUE;
        // int smallest = Integer.MAX_VALUE;
        for (int i = 0; i <= num.length; i++) {
            if (largest < num[i]) {
                largest = num[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int num[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println("largest number is " + largestnumber(num));
    }
}
