package recursion.question;

// You are given a number (eg -  2019), convert it into a String of english like“two zero one nine”.  Use a recursive function to solve this problem.NOTE-The digits of the number will only be in the range 0-9 and the lastdigit of a number can’t be 0. Sample 
// Input: 1947
// Sample 
// Output: “one nine four seven"
public class q2 {

    public static void printEnglishLetters(int number, String[] arr) {
        if (number == 0) {
            return;
        }
        printEnglishLetters(number / 10, arr); // Recursively process remaining
        // digits
        System.out.print(arr[number % 10] + " "); // Print the English representation of the current digit
    }

    public static void main(String[] args) {
        String[] digitsInWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        printEnglishLetters(1947, digitsInWords);
    }
}
