package patterns;

/*

first loop
i = 1 ; i<=n; i++ ;

inner loop
  int j = 1 ; j<=n-i ; j++ ;  
  sout(" ")

  int j = 1 ; j<=n ; j++ ;
   if(i==1||i==n|| j==n|| j==1)    for border
   

 */
public class hollow_rhombus {
    public static void rhombu(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == n || j == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rhombu(10);
    }
}