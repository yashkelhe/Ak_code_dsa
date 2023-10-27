package array;

public class Reverse_array_swap {
    public static void revers(int num[]) {
        int start = 0;
        int end = num.length - 1;

        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int num[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        revers(num);

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
