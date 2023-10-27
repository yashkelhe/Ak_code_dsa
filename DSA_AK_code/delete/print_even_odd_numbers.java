package delete;

public class print_even_odd_numbers {
    public static void main(String[] args) {
        int[] even = new int[99];
        int[] odd = new int[99];
        for (int i = 9; i <= 99; i++) {
            for (int j = 0; i <= 99; j++) {

                if (i % 2 == 0) {
                    even[j] = i;
                } else if (i % 2 != 0) {
                    odd[j] = i;
                }
            }
        }
        System.out.println("the enen numbers are: " + even);
        System.out.println("the odd numbers are: " + even);

    }
}
