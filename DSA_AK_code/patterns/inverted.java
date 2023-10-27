package patterns;
//   *

//  **
// ***

/*
dry run
   row =5

    i= 5 j = 0  h = 5
            ____*
            ___**
            __***
            _****
            *****
            



 */
public class inverted {
    public static void invert(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(" ");
            }
            for (int h = 1; h <= i; h++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        invert(3);
    }
}