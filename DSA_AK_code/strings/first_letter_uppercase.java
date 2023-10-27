package strings;

// in this question we have to make first letter if every word as upper case 
// and the string will be givien to us

// time complexity is O(n)

public class first_letter_uppercase {

    public static String toupperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        // here we are converting first letter in the upper case
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        // here we are cheacking that if space comes the there next letter will be upper
        // case
        // if it not then just add that charater in stringbuilder
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "my name is yash kelhe ";
        System.out.println(toupperCase(str));
    }
}
