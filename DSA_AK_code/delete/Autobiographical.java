package delete;

public class Autobiographical {
    public static int auto(String str) {
        int[] counts = new int[10];

        // Count occurrences of each digit in the string
        for (int i = 0; i < str.length(); i++) {
            int digit = Character.getNumericValue(str.charAt(i));
            counts[digit]++;

        }

        // Check if the string is autobiographical
        for (int i = 0; i < str.length(); i++) {
            int expectedCount = Character.getNumericValue(str.charAt(i));
            if (counts[i] != expectedCount) {
                return 0;
            }
        }

        // Count distinct digits in the string
        int distinctCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                distinctCount++;
            }
        }

        return distinctCount;
    }

    public static void main(String[] args) {
        String str = "1210";
        System.out.print(auto(str)); // Output: 3
    }
}
