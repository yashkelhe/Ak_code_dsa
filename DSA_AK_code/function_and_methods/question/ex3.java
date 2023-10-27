package function_and_methods.question;

//Write a Java program to check if a number is a palindrome inJava?(121 is a palindrome, 321 is not)A number is called a  palindrome if the number is equal to the reverse of a numbere. g.,121 is a palindrome becausethereverseof121is121itself.Ontheotherhand,321isnotapalindrome because the reverse of 321 is 123, which is not equal to 321

public class ex3 {

    public static int reverse(int n) {
        int reversed = 0;
        int original = n;
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n = n / 10;
        }

        if (reversed == original) {
            System.out.println("Yes, it's a palindrome");
        } else {
            System.out.println("No, it's not a palindrome");
        }

        return reversed;
    }

    public static void main(String[] args) {
        int result = reverse(8484);
        System.out.println(result);
    }
}