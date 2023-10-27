package condition;

import java.util.Scanner;

public class income_tax_cal {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tax;
        while (true) {
            int income = s.nextInt();
            if (income < 500000) {
                tax = 0;
            } else if (income <= 1000000 && income >= 5000000) {
                tax = (int) (income * 0.2); // type casting
            } else {
                tax = (int) (income * 0.5); // type casting
            }
            System.out.println("the tax you have to pay on this amount is : " + tax);
            s.close();
        }

    }
}
