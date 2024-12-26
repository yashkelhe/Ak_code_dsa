package strings;

public class BinaryToDecimalManual {
    public static void main(String[] args) {
        String binary = "1010"; // Example binary string
        int decimal = 0;

        // Convert binary to decimal manually
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            decimal = decimal * 2 + (bit - '0'); // Multiply current result by 2 and add the bit
        }

        System.out.println("Decimal value: " + decimal);
    }
}
