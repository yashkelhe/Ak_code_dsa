package strings;

// the name which look simillar from reverse and original then its called as palindrome 
// here we are  only using the one for loop so the time complexity is O(n)
public class palindrome {
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {

            // condition that show the string is not palindrome
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.out.println("its not a palindrome");
                return false;
            }
        }
        System.out.println("yes its palindrome");
        return true;
    }

    public static void main(String[] args) {
        String str = "racecar";
        isPalindrome(str);
    }
}
