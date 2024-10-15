package backtracking;

public class Find_SubSets {

    public static void findSubSet(String str, String ans, int i) {
        // public static void findSubSet(String str, StringBuilder ans, int i) {
        // base
        if (str.length() == i) {
            if (ans.length() == 0) {
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // recursion

        // yes
        // ans.append(str.charAt(i));

        findSubSet(str, ans + str.charAt(i), i + 1);
        // take example that when it reaches to the base case then it will
        // print thea abc and when it comes to the privouse state then it
        // will also goes to the no case and and then it will increment the
        // stack by one and print the privouse value which is in the string
        // and also here we are prvoding a string by there value so that is
        // why the string value always changes at each position

        // no
        // ans.deleteCharAt(ans.length() - 1);
        findSubSet(str, ans, i + 1);

    }
    // find subsets of the givin String

    public static void main(String[] args) {
        String str = "ABC";
        // findSubSet(str, new StringBuilder(""), 0);
        findSubSet(str, "", 0);
    }
}
