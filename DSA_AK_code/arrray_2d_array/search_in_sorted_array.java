package arrray_2d_array;

public class search_in_sorted_array {

    public static boolean staircase(int matrix[][], int key) {
        System.out.println("kye  is : " + key);
        int row = 0;
        int col = matrix[0].length - 1;
        // only foe sorted array
        // row and col will run until it reaches the end of the row and column
        while (row < matrix.length && col >= 0) {
            if (key == matrix[row][col]) {
                System.out.println("foud key a t  (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found ");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int key = 50;
        staircase(matrix, key);

    }
}
