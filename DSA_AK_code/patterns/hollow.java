package patterns;

// dry run 
/*
conditions
i= 1,j=1 , i=row ,j= column

 i = 2  , j= 1,2,3,4 
 (4,4) =
 * * * *
 *     *
 *     *
 * * * *
 

 */
// *****
// *   *
// *   *
// *****
public class hollow {
    public static void hollow_pattern(int row, int column) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1 || i == row || j == 1 || j == column) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollow_pattern(4, 5);
    }
}
