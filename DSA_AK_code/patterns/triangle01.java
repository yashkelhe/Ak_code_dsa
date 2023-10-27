package patterns;

/*
1
01
101
0101
10101

 i = 1 ; i <= n ; i++
 j= 1   ; j <= i ; j++

 if the addition of the i +j is even the print {"1"} else{"0"}

 */
public class triangle01 {
    public static void zeroOne(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        zeroOne(5);
    }
}
