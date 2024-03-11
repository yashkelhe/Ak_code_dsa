package question;

import java.util.Scanner;

public class Binary_represetation {
    public static void Binary_to_represet(int n) {
        if (n == 1) {
            System.out.println(1);
        }
        if (n > 1) {
            System.out.print(1 + " ");

            for (int i = 2; i <= n; i++) {
                String BinarRepresetation = Integer.toBinaryString(i);
                System.out.print(BinarRepresetation + " ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Binary_to_represet(n);
        sc.close();
    }
}
