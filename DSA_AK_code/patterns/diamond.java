package patterns;
/*
first loop
i = 1 ; i<=n; i++ ;

inner loop
  int j = 1 ; j<=n-i ; j++ ;  
  sout(" ")
 
  use formula {2x-1} OR {2x+1}

  use (2i-1)




 */

public class diamond {
    public static void diamon(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        diamon(7);
    }
}
