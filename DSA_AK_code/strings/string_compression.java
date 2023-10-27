package strings;

// the question is when same character comes again and again just count how any char are same at once and print character and there count 
// ex : aaabbbccc
// ouptput : a3b3c3
// and time complexity will be "O(n)" becouse this code is runnig for length of string
public class string_compression {
    public static String compression(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;

            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbccddd";
        System.out.println(compression(str));
    }
}