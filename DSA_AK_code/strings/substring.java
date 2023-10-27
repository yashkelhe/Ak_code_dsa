package strings;

// this will print substring of the string 
// but in the java there is  built in function called "subString( start ,end)"
public class substring {
    public static String substring(String path, int start, int end) {
        String substring = "";

        for (int i = start; i < end; i++) {
            substring += path.charAt(i);
        }
        return substring;
    }

    public static void main(String[] args) {
        String str = "hello world";
        // System.out.println(substring(str, 4, 5));
        System.out.println(str.substring(0, 5));
    }
}
