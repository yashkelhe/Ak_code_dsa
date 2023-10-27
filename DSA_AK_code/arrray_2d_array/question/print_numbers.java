package arrray_2d_array.question;

public class print_numbers {
    public static int printNumber(int matrix[][], int key) {
        int counter = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (key == matrix[i][j]) {
                    counter++;
                }

            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 4, 7, 8 }, { 8, 8, 7 } };
        int key = 7;
        System.out.println(printNumber(matrix, key));
    }
}
