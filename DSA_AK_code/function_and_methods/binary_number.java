package function_and_methods;

public class binary_number {

    // for to convert binary to decimal
    // public static int binaryTdecimal(int binNum) {
    // int pow = 0;
    // int decimalNumber = 0;

    // // Math.pow is power (number , and has power)
    // while (binNum > 0) {
    // int lastdigit = binNum % 10;
    // decimalNumber += lastdigit * (int) Math.pow(2, pow);
    // pow++;
    // binNum = binNum / 10; // here we decrese the mnumber by on digit
    // System.out.println("the decimal value of " + binNum + " is " +
    // decimalNumber);
    // }
    // return decimalNumber;
    // }

    // decimal to the =binary
    public static void binaryTdecimal(int n) {
        int pow = 0;
        int decimalNumber = 0;

        // Math.pow is power (number , and has power)
        while (n > 0) {
            int rem = n % 2;
            decimalNumber = decimalNumber + (rem * (int) Math.pow(10, pow));
            pow++;
            n = n / 2; // here we decrese the mnumber by on digit
        }
        System.out.print(decimalNumber);

    }

    public static void main(String[] args) {
        binaryTdecimal(7);

    }
}
