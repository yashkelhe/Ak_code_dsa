package strings;

public class DecimalToBinaryManual {
    public static void main(String[] args) {
        int decimal = 10; // Example decimal number
        StringBuilder binary = new StringBuilder();

        // Convert decimal to binary manually
        while (decimal > 0) {
            // here we are inserting from the beginning from all the will at 0 like
            // inserting
            binary.insert(0, decimal % 2); // Insert remainder at the beginning
            decimal /= 2; // Divide by 2
        }

        System.out.println("Binary value: " + binary.toString());
    }
}
