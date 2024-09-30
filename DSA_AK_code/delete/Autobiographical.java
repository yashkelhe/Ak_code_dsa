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
        System.out.println();

        int c = 20;
        int n = 100;
        int counter = 0;
        while (n > 0) {
            counter = counter + 1;
            n = (n - c);
        }

        System.out.println("the number of tines ship has to travel " + counter);

        int nn = 100;
        int cc = 20;
        int answer = nn / cc;
        int finalanswer = (nn % cc != 0) ? answer + 1 : answer;
        System.out.println("the number of tines ship has to travel round :  " + finalanswer);

        String a = "aabbcc";
        String b = "ab";
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (!b.contains(Character.toString(a.charAt(i)))) {
                newStr.append(a.charAt(i));
            }
        }

        System.out.println("The remaining string is: " + newStr.toString());

    }
}
