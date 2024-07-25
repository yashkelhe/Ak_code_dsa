package recursion;

public class Binary_String_Problem {
    // Last Place is choice
    public static void printString(int n, int lastPlcae, String sb) {
        if (n == 0) {
            System.out.println(sb);
            return;
        }
        // if (lastPlcae == 0) {
        // printString(n - 1, 0, sb.append("0"));
        // printString(n - 1, 1, sb.append("1"));
        // } else {
        // printString(n - 1, 0, sb.append("0"));
        // }

        System.out.println( "the is :  "+sb  +"  n   : "+n);
        printString(n - 1, 0, sb + "0");
        System.out.println( "the is :  "+sb  +" and n is  : "+n);
        if (lastPlcae == 0) {
            printString(n - 1, 1, sb + "1");
        }
    }

    public static void main(String[] args) {
        printString(3, 0, "");
    }
}


/*
 * 3
 * 2
 * 1
 * 0
 * 1
 * 2
 * 3
 */