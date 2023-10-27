package patterns;
/*
first loop
i = 1 ; i<=n; i++ ;

inner loop
  int j = 1 ; j<=n-i ; j++ ;  
  sout(" ")

  int j = 1 ; j<=n ; j++ ;
  sout("*")

      *****
   *****
  *****
 *****
*****

 */

public class rhombus {
    public static void rhombu(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rhombu(5);
    }
}
