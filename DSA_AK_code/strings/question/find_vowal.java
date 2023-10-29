package strings.question;

// Count how many times lower case vowels occurred in a String entered by the user.
// and vowels are a, e, i, o, u 
// and time complexity is O(n)
public class find_vowal {
    public static int count(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'u' || ch == 'o' || ch == 'a' || ch == 'i' || ch == 'e') {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String str = "yashkelhe__uuu_o_iI";
        System.out.println(count(str));

        // String str4 = "ApnaCollege".replace("l", "");
        // System.out.println(str4);
    }
}
