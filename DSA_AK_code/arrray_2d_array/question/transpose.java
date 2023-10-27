package arrray_2d_array.question;
// Write a program to FindTransposeofa Matrix

// Matrix
// a11    a12    a13
// a21    a22    a23

// Transposed Matrix
// a11    a21
// a12    a22
// a13    a23
public class transpose {
    public static void transposeOfArray(int matrix[][]) {
        display(matrix);
        int row = 2;
        int col = 3;
        int trans[][] = new int[col][row];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // swatping we will use in my opinen
                trans[j][i] = matrix[i][j];
            }
        }
        System.out.println();
        display(trans);
    }

    public static void display(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 4, 9 }, { 11, 4, 3 } };
        transposeOfArray(nums);

    }
}
