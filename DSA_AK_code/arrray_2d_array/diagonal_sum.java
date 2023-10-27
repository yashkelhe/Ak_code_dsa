package arrray_2d_array;

// here we have  to calculate the sum of all the diagnal elements in the matrix  there aare the two diagonal first one is primery and second one is secondary  when i ==i the first diagonal was give us sum and for second we will go x as 0 to (n-1) and y as (n-1) to ( 0) the i+j = n-1 then j= n-i-1;
public class diagonal_sum {
    // brut froce the time complexity O(n^2)
    // public static int diagonalSum(int[][] matrix) {
    // int sum = 0;
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix.length; j++) {
    // if (i == j) {
    // sum += matrix[i][j];
    // } else if (i + j == matrix.length - 1) {
    // sum += matrix[i][j];
    // }
    // }
    // }
    // return sum;
    // }

    // optimize way O(n)
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(diagonalSum(matrix));
    }
}
