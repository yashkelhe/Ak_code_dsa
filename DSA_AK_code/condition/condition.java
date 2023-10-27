package condition;

import java.util.Scanner;

public class condition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("enter a number");
            int a = sc.nextInt();

            if (a % 2 == 0) {
                System.out.printf("this ia a enven number : %d \n", a);
            } else {
                System.out.printf("This is a ODD number: %d \n", a);
            }
            sc.close();
        }

    }

}
