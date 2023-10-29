package strings.question;

import java.util.Arrays;

// Determine if 2 Strings areanagramsof each other.What are anagrams
// If two strings contain the same characters but in a different order,they can be said to be anagrams
public class anagrams {
    public static void anangram(String str, String str2) {
        str = str.toLowerCase();
        str2 = str2.toLowerCase();

        if (str.length() == str2.length()) {
            char[] strchr = str.toCharArray();
            char[] str2chr = str2.toCharArray();
            Arrays.sort(strchr);
            Arrays.sort(str2chr);
            boolean result = Arrays.equals(strchr, str2chr);
            if (result) {
                System.out.println("yes this is a anagram string");
            } else {
                System.out.println("this is not a anagram string");
            }
        }

    }

    public static void main(String[] args) {
        String str = "earth";
        String str2 = "heart";
        anangram(str, str2);
    }
}
