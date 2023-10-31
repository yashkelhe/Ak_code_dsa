package bit_wise_operators;

import java.util.*;

public class operators {

    public static void main(String[] args) {
        System.out.println(4 & 5);
        System.out.println(4 | 5);

        // What is the value of x^x for any valueof x?
        System.out.println(5 ^ 5);

        // here the output will be -6 becouse when you do ones compliment of the 5 then
        // its basically not the convert the 1 to 0 and 0 to 1,if msb bit is 1 then the
        // number is negative else its positive

        System.out.println("not is :" + ~(1));

        // left shift
        int result = 2;
        int ans = result << 2;

        System.out.println("left shift " + ans);
        ans = result >> 2;
        System.out.println("right shift " + ans);

        // Swap two numbers without using any third variable
        int a = 1;
        int b = 2;

        // Swap the values of a and b using addition and subtraction
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a " + a);
        System.out.println("b " + b);

        // swapping using XOR
        a = 1;
        b = 2;
        System.out.println(" swapping using XOR");
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a " + a);
        System.out.println("b " + b);

        // Add 1 to an integer using Bit Manipulation
        int x = 7;
        System.out.println(x + " + " + 1 + " is " + ~-x);

        // convert the uppercase to lowercase usiing bit wise operator

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ') + " ");

        }
        // The character conversion is done using the bitwise OR ('|') operation. The
        // code (char)(ch | ' ') takes the current uppercase character ch and applies
        // the bitwise OR operation with a space character ' '. In ASCII, the space
        // character ' ' has a binary representation where only the 6th bit (counting
        // from the right, starting at 0) is set to 1. The rest of the bits are 0.

        // When you perform a bitwise OR operation between an uppercase letter and a
        // space character, it effectively converts the 6th bit (from 1 to 0),
        // effectively converting the uppercase letter to its lowercase equivalent. The
        // result of this operation is then cast to a character, and the lowercase
        // character is printed.

    }
}
