package patterns;

/*
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1 

 i = 1  to i = n
   j = 1 to j = n - i+1 j--
                5 - 2 +1


i = 5 j = 1,2,3,4

12345
1234
123
12
1

 */
public class invert_number {
    public static void inverNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j); // 12345
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        inverNumber(5);
    }
}
